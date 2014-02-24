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

// VKBASE :
vkbase = {
	series : [
		{color:'#f54f4f'},
		{color:'#ffd370'},
		{color:'#34cf6d'},
		{color:'#58c3f0'},
		{color:'#f58f54'},
		{color:'#a8d031'},
		{color:'#58f0a9'},
		{color:'#588ef0'},
		{color:'#ff9ee4'},
		{color:'#ffad42'},
		{color:'#63cf32'},
		{color:'#58f0de'},
		{color:'#8e8efa'},
		{color:'#ff99a5'},
	],

	seriesStyles : {
		seriesColors : ['#f54f4f','#ffd370', '#34cf6d','#58c3f0','#c68efa','#f58f54','#a8d031','#58f0a9','#588ef0','#ff9ee4','#ffad42','#63cf32','#58f0de','#8e8efa','#ff99a5'],
	},
	grid : {
		drawBorder : false,
		shadow : false,
		backgroundColor : 'rgba(255, 255, 255, 0.0)'
    },
};

vkbase_full = {
	series : [
		{color:'#f54f4f'},
		{color:'#ffd370'},
		{color:'#34cf6d'},
		{color:'#58c3f0'},
		{color:'#f58f54'},
		{color:'#a8d031'},
		{color:'#58f0a9'},
		{color:'#588ef0'},
		{color:'#ff9ee4'},
		{color:'#ffad42'},
		{color:'#63cf32'},
		{color:'#58f0de'},
		{color:'#8e8efa'},
		{color:'#ff99a5'},
	],

	seriesStyles : {
		seriesColors : ['#f54f4f','#ffd370', '#34cf6d','#58c3f0','#c68efa','#f58f54','#a8d031','#58f0a9','#588ef0','#ff9ee4','#ffad42','#63cf32','#58f0de','#8e8efa','#ff99a5'],
	},
	grid : {
		drawBorder : false,
		shadow : false,
		backgroundColor : 'rgba(255, 255, 255, 0.0)'
    },
};

vkbase_pie = {
	seriesStyles : {
		seriesColors : ['#f54f4f','#ffd370', '#34cf6d','#58c3f0','#c68efa','#f58f54','#a8d031','#58f0a9','#588ef0','#ff9ee4','#ffad42','#63cf32','#58f0de','#8e8efa','#ff99a5'],
	},
	grid : {
		drawBorder : false,
		shadow : false,
		backgroundColor : 'rgba(255, 255, 255, 0.0)'
    },
};

// OldSchool :
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

// GREY SCALE:
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
themes.put('old_school', old_school);
themes.put('old_school_pie', old_school_pie);
themes.put('vkbase', vkbase);
themes.put('vkbase_pie', vkbase_pie);
themes.put('grey_scale', grey_scale);
themes.put('grey_scale_pie', grey_scale_pie);