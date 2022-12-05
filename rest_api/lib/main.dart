import 'package:flutter/material.dart'; void main() {
  runApp(const MyApp()); TextInput:Text("Default Text");
}
class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);
// This widget is the root of your application. @override
  Widget build(BuildContext context) { return MaterialApp(
    title: 'Flutter Demo', theme: ThemeData(
    primarySwatch: Colors.blue,
  ),
    home: const MyHomePage(title: 'Demo5-StateFul-Example'),
  );
  }
}
class MyHomePage extends StatefulWidget { const MyHomePage({Key? key, required this.title}) : super(key: key);
final String title; @override
State<MyHomePage> createState() => _MyHomePageState();
}
class _MyHomePageState extends State<MyHomePage> {
  int _counter = 0;
  void _incrementCounter() { setState(() {
    _counter++;
  });
  }
  void _decrementCounter() { setState(() {
    _counter--;
  });
  }
  @override

  Widget build(BuildContext context) { return Scaffold(
    appBar: AppBar(
      title: Text(widget.title),
    ),
    body: Center( child: Column(
      mainAxisAlignment: MainAxisAlignment.center, children: <Widget>[
      Text( '$_counter', style:
      Theme.of(context).textTheme.headline1,
      ),
      Row( mainAxisAlignment:MainAxisAlignment.center, children: [
        Padding( padding: const
        EdgeInsets.all(8), child:
        TextButton  (

          onPressed:_incrementCounter , child: Text('Add',
            style: TextStyle(fontSize: 30)),
        ),
        ),
        Padding( padding: const
        EdgeInsets.all(8), child:TextButton  (onPressed:_decrementCounter , child: Text('Sub',
            style: TextStyle(fontSize: 30)),



        )
        ),
      ],
      ),
    ],
    ),
    ),
  );
  }
}
