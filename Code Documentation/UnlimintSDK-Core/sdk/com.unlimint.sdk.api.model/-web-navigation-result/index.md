//[sdk](../../../index.md)/[com.unlimint.sdk.api.model](../index.md)/[WebNavigationResult](index.md)



# WebNavigationResult  
 [androidJvm] sealed class [WebNavigationResult](index.md)

Result of checking redirect url of WebView

   


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="com.unlimint.sdk.api.model/WebNavigationResult.Decline///PointingToDeclaration/"></a>[Decline](-decline/index.md)| <a name="com.unlimint.sdk.api.model/WebNavigationResult.Decline///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>object [Decline](-decline/index.md) : [WebNavigationResult](index.md)  <br>More info  <br>Web operation is declined  <br><br><br>|
| <a name="com.unlimint.sdk.api.model/WebNavigationResult.Invalid///PointingToDeclaration/"></a>[Invalid](-invalid/index.md)| <a name="com.unlimint.sdk.api.model/WebNavigationResult.Invalid///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>data class [Invalid](-invalid/index.md)(**error**: [Exception](https://developer.android.com/reference/kotlin/java/lang/Exception.html)) : [WebNavigationResult](index.md)  <br>More info  <br>Security error.  <br><br><br>|
| <a name="com.unlimint.sdk.api.model/WebNavigationResult.Skip///PointingToDeclaration/"></a>[Skip](-skip/index.md)| <a name="com.unlimint.sdk.api.model/WebNavigationResult.Skip///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>object [Skip](-skip/index.md) : [WebNavigationResult](index.md)  <br>More info  <br>Load this url  <br><br><br>|
| <a name="com.unlimint.sdk.api.model/WebNavigationResult.Success///PointingToDeclaration/"></a>[Success](-success/index.md)| <a name="com.unlimint.sdk.api.model/WebNavigationResult.Success///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>object [Success](-success/index.md) : [WebNavigationResult](index.md)  <br>More info  <br>Web operation successfully passed  <br><br><br>|


## Inheritors  
  
|  Name | 
|---|
| <a name="com.unlimint.sdk.api.model/WebNavigationResult.Success///PointingToDeclaration/"></a>[WebNavigationResult](-success/index.md)|
| <a name="com.unlimint.sdk.api.model/WebNavigationResult.Decline///PointingToDeclaration/"></a>[WebNavigationResult](-decline/index.md)|
| <a name="com.unlimint.sdk.api.model/WebNavigationResult.Skip///PointingToDeclaration/"></a>[WebNavigationResult](-skip/index.md)|
| <a name="com.unlimint.sdk.api.model/WebNavigationResult.Invalid///PointingToDeclaration/"></a>[WebNavigationResult](-invalid/index.md)|

