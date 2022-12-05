import 'package:flutter/cupertino.dart'; import 'package:flutter/material.dart';

void main()=>runApp(ClistRun());

class ClistRun extends StatelessWidget{
  const ClistRun({super.key});
 @override
Widget build(BuildContext context) {
// TODO: implement build return
 return MaterialApp(
  title: "Contact List", debugShowCheckedModeBanner: false, theme: ThemeData.light(),
  home: TestPage(),
  );
}
}
//show A contact list
class TestPage extends StatelessWidget{ @override
Widget build(BuildContext context) {
// TODO: implement build return
 return Scaffold(
  appBar:
  AppBar(
    title:Text ('Contact List') ,
  ),
  body:
  Container(
  child:new ListView( //taking column aligment vertically from start scrollDirection: Axis.vertical,
  children: <Widget>[
  Row(//taking 2 column 1:child icon 2:taking 2 child type text mainAxisAlignment: MainAxisAlignment.start,
  children: <Widget>[ Column(
  mainAxisAlignment: MainAxisAlignment.start, children:<Widget> [
  new Icon(Icons.account_circle,size: 90,)
  ],
  ),
  Column(
  crossAxisAlignment: CrossAxisAlignment.start, children:<Widget> [

  Text('Ravita Patil',textDirection: TextDirection.ltr, style: TextStyle(
  fontSize: 25,
  ),
  ),
  Text( '9321675056',
  textDirection: TextDirection.ltr, style: TextStyle(
  fontSize: 16,
  color: Colors.indigo,

  ),
  ),
  ],
  ),
  ],
  ) ,

  Row(
  mainAxisAlignment: MainAxisAlignment.start, children: <Widget>[
  Column(
  mainAxisAlignment: MainAxisAlignment.start, children:<Widget> [
  new Icon(Icons.account_circle,size: 90,)
  ],
  ),
  Column(
  crossAxisAlignment: CrossAxisAlignment.start, children:<Widget> [
  Text('Ruchita Patil',textDirection: TextDirection.ltr, style: TextStyle(
  fontSize: 25,
  ),
  ), Text('9021955872',
  textDirection: TextDirection.ltr, style: TextStyle(
  fontSize:16,
  color: Colors.indigo,
  ),
  ),
  ],
  ),
  ],

  ) ,
  ],
  ),


  ),
  );

}
}

