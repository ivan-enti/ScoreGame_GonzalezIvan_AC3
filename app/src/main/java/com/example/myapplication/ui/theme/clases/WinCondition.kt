package com.example.myapplication.ui.theme.clases

class WinCondition (
    var cross_num: Int = 0,
    var circle_num: Int = 0,
    var win: Boolean? = null,

    val max_num: Int = 3
){
    fun Reset(){
        cross_num = 0
        circle_num = 0
    }
    fun Update(cross: Boolean?){
        if(win == null) {
            when (cross) {
                true -> {
                    cross_num++
                    circle_num = 0
                    if (cross_num >= max_num) {
                        win = true
                    }
                }

                false -> {
                    circle_num++
                    cross_num = 0
                    if (circle_num >= max_num) {
                        win = false
                    }
                }

                null -> {
                    Reset()
                }
            }
        }
    }
}