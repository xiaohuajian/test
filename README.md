

日记是Timing app 一个很关键的模块，下面就涉及到的日记类型所对应的代码、业务、界面做一个说明。

日记的入口可以从个人主页的日记列表（自己的日记列表）、关注tab（关注的人发的日记）点击进入。

### 日记列表

出现列表的地方很多，我们只要抓住其核心adapter 即可，目前和日记相关的可以查询shareAdapter 及其子类HomeAdapter。

shareAdapter 涉及到的种类有图文、视频、图文专辑、视频专辑、图文/视频 + 付费live、答疑、群。



### 图片日记

界面：

<img src="https://tva1.sinaimg.cn/large/007S8ZIlgy1gfpdo1onwgj30u01hch5x.jpg" alt="image-20200612120936767" style="zoom: 25%;" />



业务 ：

点击中间的发布按钮，通过发布学习日记完成。

### 视频日记

界面

<img src="../../Library/Application Support/typora-user-images/image-20200612121407387.png" alt="image-20200612121407387" style="zoom:25%;" />

业务：

点击中间的发布按钮，通过发布长视频完成

### 图文专辑日记

界面：

<img src="../../Library/Application Support/typora-user-images/image-20200612121539341.png" alt="image-20200612121539341" style="zoom:25%;" />

业务：

这种专辑类的日记，在Timing app 中只能通过转发完成。首页我们先去搜索并购买相应的专辑，然后到个人中心==已购买== 选项中查看，对应的界面为：

<img src="../../Library/Application Support/typora-user-images/image-20200612141950118.png" alt="image-20200612141950118" style="zoom:25%;" /><img src="https://tva1.sinaimg.cn/large/007S8ZIlgy1gfphgkdh5wj30u01hc7f6.jpg" alt="image-20200612142049765" style="zoom:25%;" />



### 视频/音频专辑日记

界面：

<img src="../../Library/Application Support/typora-user-images/image-20200612144536794.png" alt="image-20200612144536794" style="zoom:25%;" />

业务：

同图文专辑一样，需要在 已购买 的列表中分享生成自己的日记。

### 图文/视频 + 付费live  日记

界面：

<img src="../../Library/Application Support/typora-user-images/image-20200612145548114.png" alt="image-20200612145548114" style="zoom:25%;" />



业务：

付费live 是星星点灯用户去开启，然后timing 的用户去关注他们，并去分享形成自己的日记。 比如 测试服“可七老师” 这个用户里面有很多的商品。

### 免费Live 直播

界面

<img src="../../Library/Application Support/typora-user-images/image-20200612193350997.png" alt="image-20200612193350997" style="zoom:25%;" />

业务 ：

有星星点灯的用户在进行免费live直播时，timing用户可以去关注并转发日记

### 答疑日记

界面：	

<img src="https://tva1.sinaimg.cn/large/007S8ZIlgy1gfpi7w72mxj30u01hck60.jpg" alt="image-20200612144703261" style="zoom:25%;" />

业务：

关注一些内容生产者，然后转发他们开启的答疑群，这样就形成了答疑日记。点击达疑界面进入答疑界面

### 群日记

界面：

<img src="https://tva1.sinaimg.cn/large/007S8ZIlgy1gfpqbckih9j30u01hc115.jpg" alt="image-20200612192712134" style="zoom:25%;" />

业务：

把自己的群和加入的群进行分享，可以形成群日记，点击群日记进入 群聊天界面 。

### 日记详情界面

上述所说的所有日记类型，如果点击文字描述部分，会去到日记详情界面 **DiaryDetailActivity** ；分析一下该界面实现：

![image-20200612220602063](https://tva1.sinaimg.cn/large/007S8ZIlgy1gfpuwmw0w5j317l0u0tjy.jpg)



点击日记内容，去到相应的内容界面，

图文 —— DiaryDetailsActivity

视频—— VideoPlayerAcitivity

图文专辑——AlbumImageTextActivirty

视频专辑——AlbumVideoAcitivity

音频专辑——MusicAlbumActivity

群分享——TeamChatAcitivity

live——SpliveAcitivity

答疑——AnsweringRoomActivity

### 添加新类型

项目中用到了框架，其大致核心类关系图：

![image-20200614150748293](https://tva1.sinaimg.cn/large/007S8ZIlgy1gfru24jmvqj31010u04j4.jpg)



假如说个人动态列表中新增里一个类型，具体如何添加一个类型？操作如下（以ShareAdapter 为例）。

1. 把数据和viewType 进行绑定，在方法getMultiType 返回新增的类型根据业务逻辑，比如服务端返回的数据type字段 等于30的，就返回新增的类型T；
2. 把viewType 和 布局layout进行绑定；在setMultiTypeDelegate 进行添加到代理类中的map里面；
3. 在绑定数据方法 convert（）；新增一个case 对该viewType 为T 时进行数据绑定进行书写。
