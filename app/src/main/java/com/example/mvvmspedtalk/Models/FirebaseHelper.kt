package com.example.mvvmspedtalk.Models

import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class FirebaseHelper {

    val db = Firebase.firestore

    fun subscribeToUserData(callback: (UserData?) -> Unit) {
        db.collection("viewData").document("personData")
            .addSnapshotListener { snapshot, e ->
                if (e != null) {
                    callback(null)
                    return@addSnapshotListener
                }

                if (snapshot != null && snapshot.exists()) {
                    val userData = snapshot.toObject(UserData::class.java)
                    callback(userData)
                } else {
                    callback(null)
                }
            }
    }

    fun setName(name: String) {
        db.collection("viewData").document("personData").update("name", name)
    }

    fun setMajor(major: String) {
        db.collection("viewData").document("personData").update("major", major)
    }

    fun setAge(age: Int) {
        db.collection("viewData").document("personData").update("age", age)
    }

}

class UserData {
    var name: String? = null
    var major: String? = null
    var age: Int? = null
}