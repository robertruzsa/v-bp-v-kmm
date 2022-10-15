package com.robertruzsa.vbpvkmm.android.features.offerlist

import android.view.ContextThemeWrapper
import android.widget.RatingBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.robertruzsa.vbpvkmm.android.R
import com.robertruzsa.vbpvkmm.android.ui.components.LocalSpacing
import com.robertruzsa.vbpvkmm.common.util.datetime.DateTimeUtil
import com.robertruzsa.vbpvkmm.features.offers.domain.model.Location
import com.robertruzsa.vbpvkmm.features.offers.domain.model.Offer
import com.robertruzsa.vbpvkmm.features.offers.domain.model.Route
import com.robertruzsa.vbpvkmm.features.offers.domain.model.User

@Preview()
@Composable
fun OfferItem(
    offer: Offer = Offer(
        user = User(),
        dateOfTravel = DateTimeUtil.now(),
        dateOfPost = DateTimeUtil.now(),
        route = Route(
            startLocation = Location("Budapest"),
            endLocation = Location("Zenta")
        ),
        numberOfSeats = 3,
        priceInHuf = 3000
    )
) {

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RectangleShape,
        elevation = 0.dp
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(LocalSpacing.current.spacing16dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(32.dp),
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(MaterialTheme.colors.primaryVariant),
                )
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = LocalSpacing.current.spacing4dp),
                    text = offer.user.name,
                    fontSize = 16.sp
                )

                Text(
                    modifier = Modifier
                        .padding(vertical = LocalSpacing.current.spacing4dp),
                    text = "15:00",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.End
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                AndroidView(
                    modifier = Modifier.wrapContentWidth(),
                    factory = { context ->
                        RatingBar(
                            ContextThemeWrapper(context, R.style.AppTheme),
                            null,
                            android.R.attr.ratingBarStyleSmall
                        ).apply {
                            setIsIndicator(true)
                            rating = offer.user.rating
                        }
                    }
                )
                Text(
                    text = offer.user.ratingWithNumberOfRatings
                )
                Text(
                    modifier = Modifier.weight(1f),
                    text = "${offer.numberOfSeats} szabad hely",
                    textAlign = TextAlign.End
                )
            }

            Text(
                modifier = Modifier.align(Alignment.End),
                text = "${offer.priceInHuf} Ft",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}
