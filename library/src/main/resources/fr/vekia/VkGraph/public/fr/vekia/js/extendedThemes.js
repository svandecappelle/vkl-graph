// MAP utility

// linking the key-value-pairs is optional
// if no argument is provided, linkItems === undefined, i.e. !== false
// --> linking will be enabled
function Map(linkItems) {
    this.current = undefined;
    this.size = 0;

    if (linkItems === false)
	this.disableLinking();
}

Map.noop = function() {
    return this;
};

Map.illegal = function() {
    throw new Error("illegal operation for maps without linking");
};

// map initialisation from existing object
// doesn't add inherited properties if not explicitly instructed to:
// omitting foreignKeys means foreignKeys === undefined, i.e. == false
// --> inherited properties won't be added
Map.from = function(obj, foreignKeys) {
    var map = new Map;

    for ( var prop in obj) {
	if (foreignKeys || obj.hasOwnProperty(prop))
	    map.put(prop, obj[prop]);
    }

    return map;
};

Map.prototype.disableLinking = function() {
    this.link = Map.noop;
    this.unlink = Map.noop;
    this.disableLinking = Map.noop;
    this.next = Map.illegal;
    this.key = Map.illegal;
    this.value = Map.illegal;
    this.removeAll = Map.illegal;

    return this;
};

// overwrite in Map instance if necessary
Map.prototype.hash = function(value) {
    return (typeof value) + ' ' + (value instanceof Object ? (value.__hash || (value.__hash = ++arguments.callee.current)) : value.toString());
};

Map.prototype.hash.current = 0;

// --- mapping functions

Map.prototype.get = function(key) {
    var item = this[this.hash(key)];
    return item === undefined ? undefined : item.value;
};

Map.prototype.put = function(key, value) {
    var hash = this.hash(key);

    if (this[hash] === undefined) {
	var item = {
	    key : key,
	    value : value
	};
	this[hash] = item;

	this.link(item);
	++this.size;
    } else
	this[hash].value = value;

    return this;
};

Map.prototype.remove = function(key) {
    var hash = this.hash(key);
    var item = this[hash];

    if (item !== undefined) {
	--this.size;
	this.unlink(item);

	delete this[hash];
    }

    return this;
};

// only works if linked
Map.prototype.removeAll = function() {
    while (this.size)
	this.remove(this.key());

    return this;
};

// --- linked list helper functions

Map.prototype.link = function(item) {
    if (this.size == 0) {
	item.prev = item;
	item.next = item;
	this.current = item;
    } else {
	item.prev = this.current.prev;
	item.prev.next = item;
	item.next = this.current;
	this.current.prev = item;
    }
};

Map.prototype.unlink = function(item) {
    if (this.size == 0)
	this.current = undefined;
    else {
	item.prev.next = item.next;
	item.next.prev = item.prev;
	if (item === this.current)
	    this.current = item.next;
    }
};

// --- iterator functions - only work if map is linked

Map.prototype.next = function() {
    this.current = this.current.next;
};

Map.prototype.key = function() {
    return this.current.key;
};

Map.prototype.value = function() {
    return this.current.value;
};

// A default set of reusable plot options. Note that line
// smoothing is turned on. Bands will be drawn with the same
// smoothing as the line.
// ////
themeBlue = {
    series : [ {
	color : 'rgba(216, 159, 60, 0.4)'
    }, {
	color : 'rgba(159, 216, 60, 0.4)'
    }, {
	color : 'rgba(60, 159, 216, 0.4)'
    }, ],
    grid : {
	drawBorder : false,
	shadow : false,
	backgroundColor : 'rgba(255, 255, 255, 0.0)'
    },
    seriesDefaults : {
	shadow : false,
	showMarker : false
    },
    axes : {
	xaxis : {
	    pad : 1.0,
	    tickOptions : {
		showGridline : false
	    }
	},
	yaxis : {
	    pad : 1.05
	}
    }
};

gabe = {
    seriesStyles : {
	seriesColors : [ 'red', 'orange', 'yellow', 'green', 'blue', 'indigo' ],
	highlightColors : [ 'lightpink', 'lightsalmon', 'lightyellow', 'lightgreen', 'lightblue', 'mediumslateblue' ]
    },
    legend : {
	fontSize : '8pt'
    },
    title : {
	fontSize : '18pt'
    },
    grid : {
	backgroundColor : 'rgb(211, 233, 195)'
    }
};
black = {
    series : [ {
	color : 'rgba(216, 159, 60, 0.4)'
    }, {
	color : 'rgba(159, 216, 60, 0.4)'
    }, {
	color : 'rgba(60, 159, 216, 0.4)'
    }, ],
    grid : {
	backgroundColor : '#000000'
    }
};
area_salmon = {
    series : [ {
	color : 'rgba(216, 159, 60, 0.4)'
    }, {
	color : 'rgba(159, 216, 60, 0.4)'
    }, {
	color : 'rgba(60, 159, 216, 0.4)'
    }, ],
    grid : {
	gridLineColor : '#666666',
	gridLineWidth : 2,
	drawBorder : false,
	shadow : false,
	backgroundColor : 'rgba(57,57,57,1.0)'
    }
};
old_school = {
    target : {
	backgroundColor : "white"
    },
    title : {
	fontFamily : 'Times New Roman',
	textColor : 'black'
    },
    axesStyles : {
	borderWidth : 0,
	ticks : {
	    fontSize : '12pt',
	    fontFamily : 'Times New Roman',
	    textColor : 'black'
	},
	label : {
	    fontFamily : 'Times New Roman',
	    textColor : 'black'
	}
    },
    grid : {
	backgroundColor : 'white',
	borderWidth : 0,
	gridLineColor : 'black',
	gridLineWidth : 2,
	borderColor : 'black'
    },
    series : [
	    {
		color : 'red',
		highlightColors : [ 'aqua', 'black', 'blue', 'fuchsia', 'gray', 'green', 'lime', 'maroon', 'navy', 'olive', 'purple', 'red',
			'silver', 'teal', 'white', 'yellow' ]
	    }, {
		color : 'green',
		highlightColors : []
	    }, {
		color : 'blue',
		highlightColors : []
	    }, {
		color : 'yellow',
		highlightColors : 'rgb(255, 245, 185)'
	    } ],
    legend : {
	background : 'white',
	textColor : 'black',
	fontFamily : 'Times New Roman',
	border : '1px solid black'
    }
};

old_school_pie = {
    seriesStyles : {
	seriesColors : [ '#FF4A62', '#FFA500', '#D07AFF', '#008000', '#7ABAFF', '#4B0082', '#95FF7A', '#DFFC57', '#FFED7A', '#A9FF7A', '#FFA07A',
		'#7AFFBD', '#0000FF', '#8E7AFF', '#FFFF00', '#FF4AF6', '#FF0000' ],
	highlightColors : []
    },
    grid : {
	backgroundColor : 'white'
    }
};
modern = {
    series : [ {
	color : '#AA4643'
    }, {
	color : '#4572A7'
    }, {
	color : '#89A54E'
    }, {
	color : '#80699B'
    }, {
	color : '#3D96AE'
    }, {
	color : '#DB843D'
    }, {
	color : '#B7B1C7'
    }, {
	color : '#E55F23'
    }, {
	color : '#686A81'
    }, {
	color : '#0F0F0F'
    }, {
	color : '#F00FF0'
    } ],

    grid : {
	backgroundColor : 'aliceblue'
    }
};
modern_pie = {
    seriesStyles : {
	seriesColors : [ '#AA4643', '#4572A7', '#89A54E', '#80699B', '#3D96AE', '#DB843D', '#B7B1C7', '#E55F23', '#686A81', '#0F0F0F', '#F00FF0' ]
    },
    grid : {
	backgroundColor : 'aliceblue'
    }
};

grey_scale = {
    series : [ {
	color : '#000000'
    }, {
	color : '#484848'
    }, {
	color : '#676767'
    }, {
	color : '#8E8E8E'
    }, {
	color : '#A9A9A9'
    }, {
	color : '#C3C3C3'
    }, {
	color : '#DEDEDE'
    } ],

    grid : {
	backgroundColor : 'white'
    }
};
// grey_scale_pie = {
// seriesStyles : {
// // seriesColors : [ '#000000', '#484848', '#676767', '#8E8E8E',
// // '#A9A9A9',
// // '#C3C3C3', '#DEDEDE' ],
// // seriesColors : [ '#FF4A62', '#FFA500', '#D07AFF', '#008000',
// // '#7ABAFF',
// // '#FF4AF6', '#FF0000' ],
// // highlightColors : []
// seriesColors : [ '#FF4A62', '#FFA500', '#D07AFF', '#008000', '#7ABAFF',
// '#4B0082', '#95FF7A', '#DFFC57', '#FFED7A', '#A9FF7A',
// '#FFA07A', '#7AFFBD', '#0000FF', '#8E7AFF', '#FFFF00',
// '#FF4AF6', '#FF0000' ],
// highlightColors : []
// },
// grid : {
// backgroundColor : 'white'
// }
// };

grey_scale_pie = {
    seriesStyles : {
	seriesColors : [ '#FF4A62', '#FFA500', '#D07AFF', '#008000', '#7ABAFF', '#4B0082', '#95FF7A', '#DFFC57', '#FFED7A', '#A9FF7A', '#FFA07A',
		'#7AFFBD', '#0000FF', '#8E7AFF', '#FFFF00', '#FF4AF6', '#FF0000' ],
	highlightColors : []
    },
    grid : {
	backgroundColor : 'white'
    }
};

var themes = new Map();
themes.put('gabe', gabe);
themes.put('blue', themeBlue);
themes.put('salmon', area_salmon);
themes.put('old_school', old_school);
themes.put('old_school_pie', old_school_pie);
themes.put('modern', modern);
themes.put('modern_pie', modern_pie);
themes.put('black', black);
themes.put('grey_scale', grey_scale);
themes.put('grey_scale_pie', grey_scale_pie);