# Deprecated
DEPRECATED! Please see [ChoserSearch](https://github.com/jhj0517/KoreanChoseongSearch). 

# KoreanChosungSearch
<img src="https://img.shields.io/badge/Kotlin-7F52FF?style=flat-square&logo=Kotlin&logoColor=white"/></a> <br>
Android library for KoreanChosungSearch.<br>
한글 초성 검색을 위한 안드로이드 라이브러리입니다.

# Installation
`build.gradle` in Project<br>

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
}
```

`build.gradle` in Module<br>

```
dependencies {
  implementation 'com.github.DeveloperJo:KoreanChosungSearch:1.0.1'
}
```

# Usage
###### Method for Korean Chosung Search:<br> 초성 검색 메소드

```
KCS.match(query,tocompare)
```
`KCS.match()` method takes two `String` variables.<br>
It compares `query` variable with `tocompare` variable. It returns `true` if it matches , `false` otherwise. <br>
For example, the following would return `true`.<br>

`KCS.match()` 메소드는 두 `String` 변수를 인자로 받습니다.<br>
`query`(검색어) 변수와 `tocompare` 변수를 서로 비교해 초성이 맞으면 `true`를, 다르면 `false`를 반환합니다.<br>
예를 들어, 다음은 `true`를 반환합니다.

```
KCS.match("ㅍ도ㅁ","포도맛")
```
<br>

You can use it like this in `Adapter`'s `Filter`. <br>
`Adapter` 의 `Filter` 에서 다음과 같이 사용할 수 있습니다.


```
...
for (item in itemList) {
    if(KCS.match(query,item)){
	resultList.add(item)
    }
}
```

<br>

![example](https://user-images.githubusercontent.com/97279763/151987180-3b9ab6aa-4f51-4c73-be7e-4b1baaa1cac0.gif)

<br>
And you can use following few methods if you need.<br>
필요하다면 다음 몇개의 메소드를 사용할 수 있습니다.<br>

###### 초성 분리 메소드

```
KCS.getCho() // it returns "ㅎ" if it takes "하"
```

한 글자를 입력받아 초성을 분리해내 추출합니다.
"하" 를 변수로 받으면, "ㅎ" 를 반환합니다.

###### 중성 분리 메소드

```
KCS.getJoong() // it returns "ㅏ" if it takes "하"
```

한 글자를 입력받아 중성을 분리해내 추출합니다.
"하" 를 변수로 받으면, "ㅏ" 를 반환합니다.

###### 종성 분리 메소드

```
KCS.getJong() // it returns "ㄹ" if it takes "할"
```

한 글자를 입력받아 종성을 분리해내 추출합니다.
"할" 을 변수로 받으면, "ㄹ" 을 반환합니다.


###### 한글 검사 메소드 <br> Method that checks it's Hangeul or not

```
KCS.isHangeul() // it returns 'true' if it takes one Hangeul char. 
```

한 글자의 `Char` 타입의 변수를 입력받아 한글이면 `true`를 , 아니면 `false` 를 반환합니다. <br>
'사'를 변수로 받으면 `true` , 한글 이외의 문자를 변수로 받으면 `false` 를 반환합니다.

