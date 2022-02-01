# KoreanChosungSearch
<img src="https://img.shields.io/badge/Kotlin-7F52FF?style=flat-square&logo=Kotlin&logoColor=white"/></a> <br>
Android library for KoreanChosungSearch.<br>
한글 초성 검색을 위한 라이브러리입니다.

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
  implementation 'com.github.DeveloperJo:KoreanChosungSearch:1.0.0'
}
```

# Usage
Method for Korean Chosung Search:<br>
초성 검색 메소드

```
KCS().match(query,tocompare)
```
`KCS().match()` method takes two `String` variables.<br>
It compares `query` variable with `tocompare` variable. It returns `true` if it matches , `false` otherwise. <br>
For example, the following would return `true`.<br>

`KCS().match()` 메소드는 두 `String` 변수를 인자로 받습니다.<br>
`query`(검색어) 변수와 `tocompare` 변수를 서로 비교해 초성이 맞으면 `true`를, 다르면 `false`를 반환합니다.<br>
예를 들어, 다음은 `true`를 반환합니다.

```
KCS().match("ㅍ도ㅁ","포도맛")
```

You can use it like this in  `Adapter`'s `SearchFilter`<br>
`Adapter` 의 `SearchFilter` 에서 다음과 같이 사용할 수 있습니다. 

```
...
for (item in itemList) {
    if(KCS().match(query,item)){
	resultList.add(item)
    }
}
```




