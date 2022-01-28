/*jshint esversion: 6 */
// import fs from node.js
const fs = require('fs');

function getNames() {
    let re = /Your card is a .*!/g;
    let res = /Your card is a /;
    let names = [];
    let namess = [];
    let data = fs.readFileSync('js/testOut.txt').toString().split('\n');
    data.forEach(element => { element.match(re) ? names.push(element.replace(res, '')) : null; });
    names.forEach(element => { namess.push(element.replace(/!/, '')); });
    namess.forEach(element => { namess = namess + element + '\n'; });
    fs.writeFileSync('js/test3.txt', namess.toString());
    console.log("Program Ended");
}

function compare(names) {
    let data = fs.readFileSync('P1RandomTest.txt');
    data.toString().split('\n');
    console.log(data.length);
    for (let i = 0; i < names.length; i++) {
        const element = names[i];
        const element2 = data[i];
        if (element !== element2) {
            console.log(`${element} is not ${element2}`);
        }
    }
}
getNames();