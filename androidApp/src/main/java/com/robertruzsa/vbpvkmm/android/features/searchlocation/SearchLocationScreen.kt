package com.robertruzsa.vbpvkmm.android.features.searchlocation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.robertruzsa.vbpvkmm.android.features.searchlocation.components.SearchScreen
import com.robertruzsa.vbpvkmm.android.util.NavUtil.getPreviousStateHandleValue
import com.robertruzsa.vbpvkmm.android.util.NavUtil.setPreviousStateHandleValue
import com.robertruzsa.vbpvkmm.common.domain.Argument
import com.robertruzsa.vbpvkmm.features.searchoffers.domain.LocationInfo

@Composable
fun SearchLocationScreen(
    navController: NavController,
    viewModel: SearchLocationViewModel = hiltViewModel()
) {

    val query by viewModel.query.collectAsState()
    val searchResults by viewModel.searchResult.collectAsState()
    val uiState by viewModel.uiState.collectAsState()

    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        val location =
            navController.getPreviousStateHandleValue<LocationInfo>(Argument.Location.key)
        location?.let {
            viewModel.setLocation(it)
        }
        focusRequester.requestFocus()
    }

    SearchScreen(
        searchFieldValue = query,
        onSearchFieldValueChange = { fieldValue ->
            viewModel.onQueryChanged(fieldValue)
        },
        searchFieldModifier = Modifier.focusRequester(focusRequester),
        searchResults = searchResults,
        onItemSelected = {
            viewModel.onLocationSelected(it)
            focusManager.clearFocus()
            navController.setPreviousStateHandleValue(
                key = Argument.Location.key,
                value = viewModel.locationType
            )
            navController.popBackStack()
        },
        onSearchFieldImeAction = {
            focusManager.clearFocus()
        },
        onClearTextClick = {
            viewModel.onClearTextClicked()
        },
        onNavigationIconClick = {
            navController.navigateUp()
        },
        uiState = uiState
    )
}
