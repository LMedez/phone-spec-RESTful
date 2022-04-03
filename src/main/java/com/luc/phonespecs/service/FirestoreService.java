package com.luc.phonespecs.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.luc.phonespecs.exceptions.ConcurrentException;
import com.luc.phonespecs.models.phone.PhoneBrand;
import com.luc.phonespecs.models.phone.production.PhoneDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class FirestoreService {

    @Autowired
    Firestore db;

    List<PhoneDetails> phoneDetailsList = new ArrayList<>();


    public List<PhoneBrand> getAllBrands() throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> future =
                db.collection("brands").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        List<PhoneBrand> phoneBrands = new ArrayList<>();
        for (DocumentSnapshot document : documents) {
            phoneBrands.add(document.toObject(PhoneBrand.class));
        }

        return phoneBrands;
    }

    public List<PhoneDetails> getLatestReleases(Integer limit) {
        try {
            CollectionReference colRef = db.collection("phone_details");
            ApiFuture<QuerySnapshot> future = colRef
                    .whereNotEqualTo("released", null)
                    .orderBy("released", Query.Direction.DESCENDING)
                    .limit(limit)
                    .get();
            List<PhoneDetails> phoneDetails = new ArrayList<>();
            for (DocumentSnapshot ds : future.get().getDocuments()) {
                phoneDetails.add(ds.toObject(PhoneDetails.class));
            }

            return phoneDetails;
        } catch (Exception e) {
            throw new ConcurrentException("Error on getting data from Firestore");
        }
    }

    public List<PhoneDetails> search(String query, Integer limit) {
        try {
            if (phoneDetailsList.isEmpty()) {

                CollectionReference colRef = db.collection("phone_details");
                ApiFuture<QuerySnapshot> future = colRef
                        .get();
                List<PhoneDetails> phoneDetails = new ArrayList<>();
                for (DocumentSnapshot ds : future.get().getDocuments()) {
                    phoneDetails.add(ds.toObject(PhoneDetails.class));
                }
                phoneDetailsList = phoneDetails;
            }

            List<PhoneDetails> strictFilter = phoneDetailsList
                    .stream()
                    .filter(phoneDetails -> phoneDetails.getName().toLowerCase().contains(query.toLowerCase()))
                    .collect(Collectors.toList());

            return strictFilter.isEmpty() ? phoneDetailsList
                    .stream()
                    .filter(phoneDetails1 -> {
                        for (String querys : query.split(" ")) {
                            return phoneDetails1.getName().toLowerCase().contains(querys.toLowerCase())
                                    || phoneDetails1.getBrand().toLowerCase().contains(querys.toLowerCase());
                        }
                        return false;
                    })
                    .limit(limit)
                    .collect(Collectors.toList()) : strictFilter;
        } catch (Exception e) {
            throw new ConcurrentException(e.getMessage());
        }
    }

    public List<PhoneDetails> getWithBestCamera(Integer limit) {
        try {
            CollectionReference colRef = db.collection("phone_details");
            ApiFuture<QuerySnapshot> future = colRef.whereArrayContainsAny("backCamera.mp", Arrays.asList("50 MP", "48 MP", "55MP", "64 MP"))
                    .whereNotEqualTo("models", null)
                    .limit(limit)
                    .get();
            List<PhoneDetails> phoneDetails = new ArrayList<>();
            for (DocumentSnapshot ds : future.get().getDocuments()) {
                phoneDetails.add(ds.toObject(PhoneDetails.class));
            }

            return phoneDetails;
        } catch (Exception e) {
            throw new ConcurrentException(e.getMessage());
        }
    }

    public List<PhoneDetails> getWithBestCameraByBrand(Integer limit, String brand) {
        try {
            CollectionReference colRef = db.collection("phone_details");
            ApiFuture<QuerySnapshot> future = colRef
                    .whereArrayContainsAny("backCamera.mp", Arrays.asList("50 MP", "48 MP", "55MP", "64 MP"))
                    .whereNotEqualTo("models", null)
                    .whereEqualTo("brand", brand)
                    .limit(limit)
                    .get();
            List<PhoneDetails> phoneDetails = new ArrayList<>();
            for (DocumentSnapshot ds : future.get().getDocuments()) {
                phoneDetails.add(ds.toObject(PhoneDetails.class));
            }

            return phoneDetails;
        } catch (Exception e) {
            throw new ConcurrentException(e.getMessage());
        }
    }
}
