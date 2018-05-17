const express = require('express');
const bodyParser = require('body-parser');
const fs = require('fs');
const urlencodedParser = bodyParser.urlencoded({ extended: false })
const server = express();

server.set('port' , (process.env.PORT || 8080) )

var elder = function(room, name){
    this.room = room;
    this.name = name;
    this.message = new Array();
};

var allElders = [new elder(1, "Mike") , new elder (2, "Mina" ), new elder(3, "Tony") , 
                new elder(4, "Charles") , new elder(5, "Yasser") , new elder(6, "Sajib")];

server.use('/img', express.static('img'));

server.get('/delete' , function(req, res)
{
    console.log("calling delete");
    var temp =  allElders[0];
    temp.message.splice(0,  temp.message.length);
        
    
    
});
server.get('/elders' , function(req, res)
{
    res.send(allElders);
});

server.get('/elders/:room', function(req, res)
{
    
    res.send(allElders[req.params.room - 1])
});
server.get('/help/:id' , function(req,res)
{
    res.sendFile(STT.html);
})




server.get('/elders/:room/:message' , function(req, res)
{
    var temp = allElders[req.params.room -1];
    temp.message.push(req.params.message);
})

server.get('*', function(req, res){
    if(fs.existsSync(__dirname + req.url))
    {
        res.sendFile(__dirname + req.url);
    }
    else
    {
       res.status(404);
       res.send('404 page not found')
       
    }
        
});
server.listen(server.get('port'), function()
{
    console.log('listening to port ' + server.get('port'));
});