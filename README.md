# Android-EventBus-Example

**Simple Android EventBus Project**

Greenrobot’s EventBus is a tiny library that allows publish-subscribe style communication between components without requiring the components to explicitly register with one another.<br>

That makes the data exchange between components like Activity, Fragment, Services and any kind of backgrounds threads pretty easy.<br>


![not found picture](http://www.andreas-schrade.de/assets/eventbus-greenrobot.jpg)


### Register: <br>
`EventBus.getDefault().register(this);`<br>

### UnRegister:<br>
`EventBus.getDefault().unregister(this);`<br>

### Subscribe: <br>
`@Subscribe`<br>
`public void onEvent(MessageEvent event) {`<br>
`Toast.makeText(this, "Hey, my message" + event.getMessage(), Toast.LENGTH_SHORT).show();`<br>
`}`<br>

### Post: <br>
`EventBus.getDefault().postSticky(new MessageEvent("Hey event subscriber!"));`<br>
`EventBus.getDefault().post(new MessageEvent("Hey event subscriber!"));`
