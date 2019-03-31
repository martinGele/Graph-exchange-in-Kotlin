package com.martin.kotlincleanarchitecture.util

import com.anychart.AnyChart
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.charts.Cartesian
import com.anychart.data.Set
import com.anychart.enums.Anchor
import com.anychart.enums.MarkerType
import com.anychart.enums.TooltipPositionMode
import com.anychart.graphics.vector.Stroke

fun initGraph(series: MutableList<HashMap<String, Any>>): Cartesian? {
    val cartesian = AnyChart.line()

    cartesian.animation(true)

    cartesian.padding(10.0, 10.0, 5.0, 10.0)


    cartesian.crosshair().enabled(true)
    cartesian.crosshair()
        .yLabel(true)
        .yStroke(null as Stroke?, null, null, null as String?, null as String?)

    cartesian.tooltip().positionMode(TooltipPositionMode.POINT)


    val seriesData = arrayListOf<DataEntry>()

    for (point in series) {
        /**
         * get all the data from the hash map and present it on the graph
         */

        seriesData.add(CustomDataEntry(point["date"].toString(), point["value"] as Number))
    }
    val set = Set.instantiate()
    set.data(seriesData)
    val series1Mapping = set.mapAs("{ x: 'x', value: 'value' }")


    val series1 = cartesian.line(series1Mapping)
    series1.hovered().markers().enabled(true)
    series1.hovered().markers()
        .type(MarkerType.CIRCLE)
        .size(4.0)
    series1.tooltip()
        .position("right")
        .anchor(Anchor.LEFT_CENTER)
        .offsetX(5.0)
        .offsetY(5.0)





    return cartesian
}