package net.mu_elma.example.simpletodoapplication

import android.arch.lifecycle.LifecycleActivity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.widget.TextView

import net.mu_elma.example.simpletodoapplication.issue.IssueViewModel
import net.mu_elma.example.simpletodoapplication.issue.IssueViewModelFactory

class ToDoAppActivity : LifecycleActivity() {
    val issueViewModel by lazy { ViewModelProviders
                .of(this, IssueViewModelFactory(ToDoRepository))
                .get(IssueViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_app)

        // LiveDataのsetValueが呼ばれると発火し、ここが呼ばれる
        issueViewModel.issues.observe(this,
                Observer { issues ->
                    // ここでViewに反映させる
                    if (issues != null) {
                        val textView = findViewById(R.id.text) as TextView
                        textView.text = issues[0].title
                        Log.d("todoApp", issues[0].toString())
                        Log.d("todoApp", issues[1].toString())
                        Log.d("todoApp", issues[2].toString())
                    }
                }
        )
        // 試しに発火させる
        issueViewModel.testSet(0)
    }
}
