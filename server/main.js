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
    console.log("Got connection");
    var gameFile = fs.createReadStream("game.dat");
    var pipe = gameFile.pipe(response);
    pipe.on('close', function() {
	response.status(200).end();
	console.log("File sent!");
    });
});

//Save game
app.post( '/save', function( request, response ) {
    console.log("Got connection");
    var gameFile = fs.createWriteStream("game.dat");
    var pipe = request.pipe(gameFile, { end: true });
    pipe.on('close', function() {
	response.status(200).end();
	console.log("File received!");
    });
});

//Start server
var port = 4711;
app.listen( port, function() {
    console.log( 'Express server listening on port %d in %s mode', port, app.settings.env );
});
