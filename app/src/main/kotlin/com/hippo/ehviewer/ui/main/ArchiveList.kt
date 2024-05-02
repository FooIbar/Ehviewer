package com.hippo.ehviewer.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.hippo.ehviewer.R
import com.hippo.ehviewer.client.EhUtils
import com.hippo.ehviewer.client.parser.Archive
import com.hippo.ehviewer.client.parser.Funds

@Composable
fun ArchiveList(
    funds: Funds,
    items: List<Archive>,
    onItemClick: (Archive) -> Unit,
    modifier: Modifier = Modifier,
) {
    val currentFunds = stringResource(R.string.current_funds)
    val archiveFree = stringResource(R.string.archive_free)
    val archiveOriginal = stringResource(R.string.archive_original)
    val archiveResample = stringResource(R.string.archive_resample)
    val fundsStyle = MaterialTheme.typography.labelLarge
    val fundsGP = buildString {
        append("%,d".format(funds.fundsGP))
        // Ex GP numbers are rounded down to the nearest thousand
        if (EhUtils.isExHentai) {
            append('+')
        }
    }
    val fundsC = "%,d".format(funds.fundsC)
    val (hAtH, nonHAtH) = items.partition { it.isHAtH }
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        item(span = { GridItemSpan(maxLineSpan) }, contentType = "funds") {
            Text(text = currentFunds, textAlign = TextAlign.Center)
        }
        item(contentType = "funds") {
            FundsItem(
                type = "GP",
                amount = fundsGP,
                modifier = Modifier.fillMaxWidth(),
                textStyle = fundsStyle,
            )
        }
        item(contentType = "funds") {
            FundsItem(
                type = "C",
                amount = fundsC,
                modifier = Modifier.fillMaxWidth(),
                textStyle = fundsStyle,
            )
        }
        items(nonHAtH, contentType = { "archive" }) {
            ArchiveItem(
                name = if (it.res == "org") archiveOriginal else archiveResample,
                cost = if (it.cost == "Free!") archiveFree else it.cost,
                size = it.size,
                onClick = { onItemClick(it) },
            )
        }
        item(span = { GridItemSpan(maxLineSpan) }, contentType = "divider") {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
                Text(text = "H@H")
            }
        }
        items(hAtH, contentType = { "archive" }) {
            ArchiveItem(
                name = if (it.res == "org") archiveOriginal else it.name,
                cost = if (it.cost == "Free") archiveFree else it.cost,
                size = it.size,
                onClick = { onItemClick(it) },
            )
        }
    }
}

@Composable
private fun ArchiveItem(
    name: String,
    cost: String,
    size: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val labelStyle = MaterialTheme.typography.labelMedium
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = cost,
            style = labelStyle,
        )
        Button(onClick = onClick) {
            Text(text = name)
        }
        Text(
            text = size,
            style = labelStyle,
        )
    }
}
