package com.rajapps.bookshub.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rajapps.bookshub.R
import com.rajapps.bookshub.adapter.DashboardRecyclerAdapter
import com.rajapps.bookshub.model.Book


class DashboardFragment : Fragment() {

 lateinit var recyclerDashboard : RecyclerView
 lateinit var layoutManager: RecyclerView.LayoutManager

 lateinit var  recyclerAdapter: DashboardRecyclerAdapter

 val bookList = arrayListOf(
     "p.s. I Love You", "The Great Gatsby", "Anna karenina","Madane Bovary",
     "War and Peace", "Lolita", "Middlemarch", "The Adventures of Huckleberry finn",
     "Moby-Dick", " The Lord of the Rings"
 )

    val bookInfoList = arrayListOf<Book>(
        Book(
            "Daring Greatly",
            "Brene Brown",
            "Rs.299",
            "4.5",
            R.drawable.daring_greatly
        ),
        Book(
            "Eat That Frog First",
            "Brian Tracy",
            "Rs.299",
            "4.5",
            R.drawable.eat_that_frog
        ),
        Book(
            "Failing Forward",
            "John Maxwell",
            "Rs.399",
            "4.5",
            R.drawable.failing_forward
        ),
        Book(
            "Feeling Good",
            "David Burns",
            "Rs.299",
            "4.5",
            R.drawable.feeling_good
        ),
        Book(
            "Fooled",
            "Nassim Taleb",
            "Rs.199",
            "3.5",
            R.drawable.foole
        ),
        Book(
            "How to Win and Influence Friends",
            "Dale Carnegie",
            "Rs.499",
            "4.6",
            R.drawable.how_to_win
        ),
        Book(
            "Perfect Health",
            "Paul Jameniet",
            "Rs.299",
            "4.5",
            R.drawable.perfect_health_diet
        ),Book(
            "Mindsight",
            "Daniel Siegel",
            "Rs.299",
            "4.5",
            R.drawable.mindsight
        ),
        Book(
            "The Paleo Manifesto",
            "John Durant",
            "Rs.99",
            "3.5",
            R.drawable.paleo_manifesto
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        recyclerDashboard = view.findViewById(R.id.recyclerDashboard)

        layoutManager = LinearLayoutManager(activity)

        recyclerAdapter = DashboardRecyclerAdapter(activity as Context, bookInfoList)

        recyclerDashboard.adapter = recyclerAdapter
        recyclerDashboard.layoutManager = layoutManager

        recyclerDashboard.addItemDecoration(
            DividerItemDecoration(
                recyclerDashboard.context,
                (layoutManager as LinearLayoutManager).orientation
            )
        )

        return view
    }


}