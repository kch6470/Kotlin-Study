package com.example.textviewkt

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.textviewkt.databinding.ActivityMainBinding
import java.net.URL

class MainActivity : AppCompatActivity() {

    // lateinit var로 엑티비티를 바인딩 시켜준다
    private lateinit var binding : ActivityMainBinding

    //OnCreate 웹이 최초 실행 됐을때 수행, Unity에서 start 혹은 awake의 역할
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //화면 뷰 연결 전 바인딩 정의
        binding = ActivityMainBinding.inflate(layoutInflater)
        // activity_main.xml 화면 뷰를 연결한다
        setContentView(binding.root)

        //바인딩된 뷰의 UI id를 활용해서 코드처리
        binding.TextViewTitle.setText("하이루")
        binding.textViewSendMsg.setText("ㅇㅅㅇ")
        binding.ButtonGetText.setOnClickListener {
            var resultText = binding.PlainTextId.text.toString()
            binding.TextViewTitle.setText(resultText)
        }

        //씬 전환 버튼 Listener 설정
        binding.ButtonChangeScene.setOnClickListener {
            // var : 언제든지 변경 될 수 있는 variable
            // val : final 값이 변경되지 못하는 수
            
            //씬 전환을 위한 intent 객체 생성
            val intent_SubActivity = Intent(this, SubActivity::class.java)
            
            //textViewSendMsg 에 있는 text 값을 msg라는 키로 잠궜다
            intent_SubActivity.putExtra("msg",binding.textViewSendMsg.text.toString())
            startActivity(intent_SubActivity)
        }


        // Toast 메세지 버튼
        binding.ButtonToastMsg.setOnClickListener {
            //토스트 메세지
            Toast.makeText(this@MainActivity, "버튼이 클릭 되었습니다.", Toast.LENGTH_SHORT).show()

            //이미지 변환
            binding.imageViewProfile.setImageResource(R.drawable.star)
//          //URL 사용시
//            val imageUrl = "https://picsum.photos/600/400.jpg"
//            Glide.with(this)
//                .load(imageUrl)
//                .into(binding.imageViewProfile)
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
    }
}