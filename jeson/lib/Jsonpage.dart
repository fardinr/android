import 'dart:convert';
import 'package:flutter/material.dart';
class Jsonpage extends StatefulWidget{
  @override
  JsonpageState createState() => JsonpageState();

}

class JsonpageState extends State <Jsonpage>{
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title:Text(("load json file from local")),),
      body: Center(
// Use future builder and DefaultAssetBundle to load the local JSON file

        child:FutureBuilder(builder: (context,snapshot){
// Decode the JSON
          var showData=json.decode(snapshot.data.toString());
          return ListView.builder(
            itemBuilder:(BuildContext context,int index){
              return ListTile(
                title: Text(showData[index]['name']),
                subtitle: Text(showData[index]['price']),
              );
            },
            itemCount:showData.length,
          );
        },
            future:DefaultAssetBundle.of(context).loadString("assets/Productlist.json")
        ),
      ),
    );

  }

}
