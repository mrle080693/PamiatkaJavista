function save(pageName, userName, comment) {
    var commentObj =
        '{' +
        '"id":0 ' +
        ',"pageName":' + '"' + pageName + '"' +
        ',"userName":' + '"' + userName + '"' +
        ',"comment":' + '"' + comment + '"' +
        '}';

    console.log('js file connected');
    console.log(commentObj);
    // var myObj = JSON.parse(myJSON);
    // document.getElementById("demo").innerHTML = myObj.name;
}
