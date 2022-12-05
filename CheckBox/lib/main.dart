import 'package:flutter/material.dart'; void main() {
  runApp(MyApp( TextInput:Text("Paid/Unpaid"),));
}
class MyApp extends StatefulWidget { MyApp({required this.TextInput});
final Widget TextInput; MyAppState createState() => new MyAppState();
}
class MyAppState extends State<MyApp> {
  bool checkBoxValue = false; String actionText="Default"; @override
  Widget build(BuildContext ctxt)
  {
    return MaterialApp( title:
    "MySampleApplication", home: Scaffold(
        appBar: AppBar(
          title: Text("Hello Flutter App"),), body: Center(
      child:Column( children: <Widget>[ widget.TextInput, Text(actionText), Checkbox(value:
      checkBoxValue, onChanged: (bool ? newValue)
      {
        setState(() { checkBoxValue=newValue!; if(newValue==true) { actionText = "Checked";
        }
        else
        {
          actionText="unChecked";

        }
        });
      }
      )
      ],
      ),
    )
    ),
    );
  }
}
