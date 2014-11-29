// Module dependencies.
var application_root = __dirname,
    express = require( 'express' ),
    cors = require('cors'),
    fs = require('fs');

//Create server
var app = express();

// Configure server
app.configure( function() {
    //checks request.body for HTTP method overrides
    app.use( express.methodOverride() );

    app.use(cors());

    //perform route lookup based on url and HTTP method
    app.use( app.router );

    //Show all errors in development
    app.use( express.errorHandler({ dumpExceptions: true, showStack: true }));
});

//Router
//Load game
app.get( '/load', function( request, response ) {

});

//Save game
app.post( '/save', function( request, response ) {
/*    if (typeof request.body.content == 'undefined' || typeof request.body.completed == 'undefined') {
	response.status(400).end();
	console.log(request.body);
	} else {
	    var task = new Task(request.body.content, request.body.completed);
	    tasks.push(task);
	        
	        response.send(task);
	    }*/
    console.log("Got connection");
    var gameFile = fs.createWriteStream("game.dat");
    var pipe = request.pipe(gameFile, { end: true });
    pipe.on('close', function() {
	response.status(200).end();
	console.log("File saved!");
    });
});

//Start server
var port = 4711;
app.listen( port, function() {
    console.log( 'Express server listening on port %d in %s mode', port, app.settings.env );
});
