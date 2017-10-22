package com.example.trungnguyen.tancangproject.activity

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.trungnguyen.tancangproject.R
import com.example.trungnguyen.tancangproject.utils.maps.DirectionFinder
import com.example.trungnguyen.tancangproject.utils.maps.DirectionFinderListener
import com.example.trungnguyen.tancangproject.utils.maps.Route
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.Polyline
import com.google.android.gms.maps.model.PolylineOptions
import java.io.UnsupportedEncodingException
import java.util.*

class DetailActivity : AppCompatActivity(), OnMapReadyCallback, DirectionFinderListener {
    private lateinit var mMap: GoogleMap
    private var originMarkers: MutableList<Marker> = ArrayList()
    private var destinationMarkers: MutableList<Marker> = ArrayList()
    private var polylinePaths: MutableList<Polyline> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        try {
            DirectionFinder(this, "10.7626772, 106.6825692", "10.86777, 106.803552").execute()
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
        }

    }

    override fun onMapReady(p0: GoogleMap) {
        mMap = p0
    }

    override fun onDirectionFinderStart() {
        for (marker in originMarkers) {
            marker.remove()
        }

        for (marker in destinationMarkers) {
            marker.remove()
        }

        for (polyline in polylinePaths) {
            polyline.remove()
        }
    }

    override fun onDirectionFinderSuccess(routes: MutableList<Route>?) {
        polylinePaths = ArrayList<Polyline>()
        originMarkers = ArrayList<Marker>()
        destinationMarkers = ArrayList<Marker>()

        if (routes != null) {
            for (route in routes) {
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(route.startLocation, 12f))

                originMarkers.add(mMap.addMarker(MarkerOptions()
                        .title(route.startAddress)
                        .position(route.startLocation)))
                destinationMarkers.add(mMap.addMarker(MarkerOptions()
                        .title(route.endAddress)
                        .position(route.endLocation)))

                val polylineOptions = PolylineOptions().geodesic(true).color(Color.BLUE).width(10f)

                for (i in 0 until route.points.size)
                    polylineOptions.add(route.points.get(i))

                polylinePaths.add(mMap.addPolyline(polylineOptions))
            }
        }
    }

}
