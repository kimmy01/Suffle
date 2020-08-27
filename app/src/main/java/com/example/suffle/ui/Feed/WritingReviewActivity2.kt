package com.example.suffle.ui.Feed

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.text.Editable
import android.widget.Toast
import androidx.core.content.FileProvider
import com.example.suffle.R
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_writing_review2.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class WritingReviewActivity2 : AppCompatActivity() {

    val REQUEST_IMAGE_CAPTURE = 1 //카메라 사진 촬영 요청 코드
    lateinit var curPhotoPath: String // 문자열 형태의 사진 경로 값 (초기값 null)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writing_review2)

        /////////////////////////////////////////////////////////////////////////////////////
        val storename = intent.getStringExtra("storeName")
        textView_writingReview2_8.text = storename

        val content = editText_writingReview2.text

        textView_writingReview2_1.setOnClickListener {
            //Toast.makeText(this, content, Toast.LENGTH_SHORT).show()
            textView_writingReview2_test.setText(content)
        }

        imageView_writingReview2_before.setOnClickListener { onBackPressed() }
        textView_writingReview2_2.setOnClickListener {

            val intent = Intent(this, WritingReviewActivity3::class.java)
            intent.putExtra("storeName", storename)
            intent.putExtra("content", content)
            startActivity(intent)
        }
        ///////////////////////////////////////////////////////////////////////////////////////

        setPermission() //권한 체크 메소드 실행
        constraintLayout_writingReview2_4.setOnClickListener{
            takeCapture()
        }

    }


    //테드 퍼미션 설정
    private fun setPermission() {
        val permission = object: PermissionListener {
            override fun onPermissionGranted() { //설정한 위험권한들이 허용 됐을 경우 이 곳 수행
                //Toast.makeText(this@WritingReviewActivity2, "권한이 허용 되었습니다", Toast.LENGTH_SHORT).show()
            }

            override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                //설정한 위험권한 둘 중 거부를 한 경우 이곳을 수행
                //Toast.makeText(this@WritingReviewActivity2, "권한이 거부 되었습니다", Toast.LENGTH_SHORT).show()
            }
        }

        TedPermission.with(this)
            .setPermissionListener(permission)
            .setRationaleMessage("카메라 앱을 사용하시려면 권한을 허용해 주세요")
            .setDeniedMessage("권한을 거부하셨습니다. [앱 설정] -> [권한] 항목에서 허용해 주세요.")
            .setPermissions(android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.CAMERA)
            .check()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //startActivityForResult를 통해서 기본 카메라 앱으로 부터 받아온 사진 결과 값
        super.onActivityResult(requestCode, resultCode, data)
        //이미지를 성공적으로 가져왔다면
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {

            val bitmap: Bitmap
            val file = File(curPhotoPath)
            if (Build.VERSION.SDK_INT < 28) { //안드로이드 9.0 버전보다 낮을 경우
                bitmap = MediaStore.Images.Media.getBitmap(contentResolver, Uri.fromFile(file))
                imageView_writingReview2_gallery.setImageBitmap(bitmap)
            } else {
                val decode = ImageDecoder.createSource(
                    this.contentResolver,
                    Uri.fromFile(file)
                )
                bitmap = ImageDecoder.decodeBitmap(decode)
                imageView_writingReview2_gallery.setImageBitmap(bitmap)
            }
            savePhoto(bitmap)
        }
    }

    //갤러리에 저장
    private fun savePhoto(bitmap: Bitmap) {
        val folderPath = Environment.getExternalStorageDirectory().absolutePath + "/Pictures/" // 사진 폴더로 저장하기 위한 경로
        val timestamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val fileName = "${timestamp}.jpeg"
        val folder = File(folderPath)
        if(!folder.isDirectory) {//현재 해당 경로에 폴더가 존재하지 않는다면
            folder.mkdirs() // make directory 줄임말로 해당 경로에 폴더 자동으로 새로 만들기
        }
        //실제 저장처리
        val out = FileOutputStream(folderPath + fileName)
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)
        Toast.makeText(this, "사진이 앨범에 저장되었습니다", Toast.LENGTH_SHORT).show()

    }

    //카메라, 갤러리 불러오기
    private fun takeCapture() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also{ takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                val photoFile: File? = try {
                    createImageFile()
                } catch (ex: IOException) {
                    null
                }
                photoFile?.also {
                    val photoURI: Uri = FileProvider.getUriForFile(
                        this,
                        "com.example.suffle.fileprovider",
                        it
                    )
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
            }
        }
    }
    //이미지 파일 생성
    private fun createImageFile(): File {
        val timestamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile("JPEG_${timestamp}_", ".jpg", storageDir)
            .apply{curPhotoPath = absolutePath}
    }

}