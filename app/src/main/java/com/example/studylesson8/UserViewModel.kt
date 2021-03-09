package com.example.studylesson8

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel: ViewModel() {
    /**
     * array of users
     */
    var userList: MutableLiveData<Array<User>> = MutableLiveData()

    /**
     * curent index of array
     */
    var curIndex:Int = 0;

    /**
     * get users data on init
     */
    init{
        userList.value = UserData.getUserArray()
    }

    /**
     * get next user from array from current
     */
    fun getNextUser(){
        if(curIndex < userList.value?.size ?: 0 ) {
            curIndex++
        }
        userList.value?.get(curIndex)?: User("None", "None")
    }

    /**
     * get previous user from array from current
     */
    fun getPrevUser(){
        if(curIndex > 0) {
            curIndex--
        }
        userList.value?.get(curIndex)?: User("None", "None")
    }
}