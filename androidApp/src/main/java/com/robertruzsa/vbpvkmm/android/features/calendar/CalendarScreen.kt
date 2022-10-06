package com.robertruzsa.vbpvkmm.android.features.calendar

import android.widget.CalendarView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.robertruzsa.vbpvkmm.android.ui.components.TopBar
import com.robertruzsa.vbpvkmm.android.util.NavUtil.getPreviousStateHandleValue
import com.robertruzsa.vbpvkmm.android.util.NavUtil.setPreviousStateHandleValue
import com.robertruzsa.vbpvkmm.common.domain.Argument
import com.robertruzsa.vbpvkmm.common.util.datetime.DateTimeUtil
import kotlinx.datetime.LocalDateTime

@Composable
fun CalendarScreen(
    navController: NavController,
    viewModel: CalendarViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopBar(
            title = "Mikor utazol?",
            navigationIcon = Icons.Filled.ArrowBack,
            onNavigationIconClick = {
                navController.navigateUp()
            }
        )
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { context ->
                CalendarView(context).apply {
                    minDate = viewModel.minDate
                    val selectedDate =
                        navController.getPreviousStateHandleValue<LocalDateTime>(Argument.Date.key)
                    selectedDate?.let {
                        date = DateTimeUtil.toEpochMillis(it)
                    }
                }
            },
            update = { view ->
                view.setOnDateChangeListener { _, year, month, dayOfMonth ->
                    val selectedDate = LocalDateTime(year, month + 1, dayOfMonth, 0, 0)
                    navController.setPreviousStateHandleValue(
                        key = Argument.Date.key,
                        value = selectedDate
                    )
                    navController.popBackStack()
                }
            }
        )
    }
}
