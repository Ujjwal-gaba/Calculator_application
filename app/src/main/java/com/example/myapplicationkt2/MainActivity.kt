package com.example.myapplicationkt2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

private var firstNum = 0.0
private  var secondNum = 0.0
private var currOp = '$'

private val calcLogic = CalcLogic()


class MainActivity : AppCompatActivity(), View.OnClickListener {


override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    attachListeners()
}

private fun attachListeners(){
    btnClr.setOnClickListener(this)
    btnEq.setOnClickListener(this)
    btnAdd.setOnClickListener(this)
    btnSub.setOnClickListener(this)
    btnMul.setOnClickListener(this)
    btnDiv.setOnClickListener(this)
    btn1.setOnClickListener(this)
    btn2.setOnClickListener(this)
    btn3.setOnClickListener(this)
    btn4.setOnClickListener(this)
    btn5.setOnClickListener(this)
    btn6.setOnClickListener(this)
    btn7.setOnClickListener(this)
    btn8.setOnClickListener(this)
    btn9.setOnClickListener(this)
    btn0.setOnClickListener(this)
}

private fun displayNum(currNum:Int){
    if (currOp != '$'){
        secondNum = secondNum*10 +currNum
        secondnum.text = secondNum.toString()
    }else{
        firstNum = firstNum*10 + currNum
        firstnum.text = firstNum.toString()
    }
}

private fun displayOp(inputOp:Char){
    currOp = inputOp
    op.text = currOp.toString()
}

override fun onClick(p0: View) {
    when(p0.id){
        R.id.btn0 -> displayNum(0)
        R.id.btn1 -> displayNum(1)
        R.id.btn2 -> displayNum(2)
        R.id.btn3 -> displayNum(3)
        R.id.btn4 -> displayNum(4)
        R.id.btn5 -> displayNum(5)
        R.id.btn6 -> displayNum(6)
        R.id.btn7 ->displayNum(7)
        R.id.btn8 -> displayNum(8)
        R.id.btn9 -> displayNum(9)
        R.id.btnAdd -> displayOp('+')
        R.id.btnSub -> displayOp('-')
        R.id.btnMul -> displayOp('*')
        R.id.btnDiv -> displayOp('/')
        R.id.btnEq->{
            val result = calcLogic.evaluate(firstNum, secondNum,currOp)
            tv.text = result.toString()
        }
        R.id.btnClr->{tv.text="0"
            op.text="0"
            firstnum.text="0"
            secondnum.text="0"
             var firstNum = 0.0
              var secondNum = 0.0
             var currOp = '$'
        }


    }
}
}
