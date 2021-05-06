package com.sriyank.vacationspots

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.sriyank.vacationspots.roomdb.AppDatabase


class DestinationViewModel(application: Application): AndroidViewModel(application) {

    val destinationsLiveData: LiveData<PagedList<Destination>>

    init {
        val appDatabase = AppDatabase.getDatabase(application)
        val destinationDao = appDatabase!!.destinationDao()
        val dataSourceFactory = destinationDao.getAllPagedDestinations()
        destinationsLiveData = dataSourceFactory.toLiveData(pageSize = 10)
    }
}
