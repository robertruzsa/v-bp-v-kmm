package com.robertruzsa.vbpvkmm.android.features.calendar

import androidx.lifecycle.ViewModel
import com.robertruzsa.vbpvkmm.common.util.datetime.DateTimeUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject constructor() : ViewModel() {

    val minDate = DateTimeUtil.toEpochMillis(DateTimeUtil.now())
}
