package com.example.textviewkt

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.textviewkt.databinding.ActivityMainBinding
import com.example.textviewkt.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {

    // lateinit var로 엑티비티를 바인딩 시켜준다
    private lateinit var binding : ActivitySubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //화면 뷰 연결 전 바인딩 정의
        binding = ActivitySubBinding.inflate(layoutInflater)
        // activity_main.xml 화면 뷰를 연결한다
        setContentView(binding.root)

        //전환되면서 "msg" 라는 키 값이 있으면
        if(intent.hasExtra("msg"))
        {
            //바인딩된 TextViewGetMsg 의 텍스트를 "msg" 키값에 대응되는 string으로 바꾼다
            binding.TextViewGetMsg.text = intent.getStringExtra("msg")
        }
        
        val item = arrayOf("사과", "배", "키위", "하미과", "석류")
        // context란 한 액티비티의 모든 정보를 담고있다.
        binding.ListView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, item)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}