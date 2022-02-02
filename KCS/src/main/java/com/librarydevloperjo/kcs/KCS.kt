package com.librarydevloperjo.kcs

class KCS {

    companion object{

    private const val UNICODE_HangulStart = 44032
    private const val UNICODE_HangulLast = 55203


    private val CHO = listOf("ㄱ","ㄲ","ㄴ","ㄷ","ㄸ","ㄹ","ㅁ","ㅂ","ㅃ", "ㅅ","ㅆ","ㅇ","ㅈ","ㅉ","ㅊ","ㅋ","ㅌ","ㅍ","ㅎ")
    private val JOONG = listOf("ㅏ","ㅐ","ㅑ","ㅒ","ㅓ","ㅔ","ㅕ","ㅖ","ㅗ","ㅘ", "ㅙ","ㅚ","ㅛ","ㅜ","ㅝ","ㅞ","ㅟ","ㅠ","ㅡ","ㅢ","ㅣ")
    private val JONG = listOf("","ㄱ","ㄲ","ㄳ","ㄴ","ㄵ","ㄶ","ㄷ","ㄹ","ㄺ","ㄻ","ㄼ", "ㄽ","ㄾ","ㄿ","ㅀ","ㅁ","ㅂ","ㅄ","ㅅ","ㅆ","ㅇ","ㅈ","ㅊ","ㅋ","ㅌ","ㅍ","ㅎ")

    /*
    Korean unicode formular = (cho * 21 + joong) * 28 + jong + 0xAC00
    */

    fun match(query:String,tocompare:String):Boolean{
        var matched=false

        if( tocompare.length >= query.length && !(isOnlyCho(query).isNullOrEmpty()) ){

            val choindexes = isOnlyCho(query)
            val compareChars = tocompare.toCharArray()

            for(i in choindexes){
                val cho = getCho(tocompare[i].toString())
                compareChars[i]= cho.single()
            }
            val compareReplaced = String(compareChars)

            if(compareReplaced.contains(query)){
                matched= true
            }

        }else if(tocompare.contains(query)){
            matched = true
        }
        return matched
    }

    fun isOnlyCho(word:String):ArrayList<Int>{
        val choindexList = ArrayList<Int>()

        for(cho_ in CHO){
            if(word.contains(cho_)){
                var same_index = word.indexOf(cho_)
                while(same_index>=0){
                    choindexList.add(same_index)
                    same_index = word.indexOf(cho_,same_index+1)
                }
            }
        }
        return choindexList
    }

    fun getCho(word:String):String{
        var word_cho = word

        if(isHangeul(word.single())){
            val charuni = word[0]
            val cho_uniIndex = ((charuni.code-0xAC00) / 28 /21).toChar().code
            word_cho = CHO[cho_uniIndex]
        }

        return word_cho
    }

    fun getJoong(word:String):String{
        var word_joong = word

        if(isHangeul(word.single())){
            val charuni = word[0]
            val joong_uniIndex = ((charuni.code-0xAC00) / 28 %21).toChar().code
            word_joong = JOONG[joong_uniIndex]
        }
        return word_joong
    }

    fun getJong(word:String):String{
        var word_jong = word

        if(isHangeul(word.single())){
            val charuni = word[0]
            val jong_uniIndex = ((charuni.code-0xAC00) %28).toChar().code
            word_jong = JONG[jong_uniIndex]
        }
        return word_jong
    }

    fun isHangeul(word: Char): Boolean {
        return UNICODE_HangulStart <= word.code && word.code <= UNICODE_HangulLast
    }

    }
}