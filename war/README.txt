Title: jqPlot Readme

Pure JavaScript plotting plugin for jQuery.

To learn how to use jqPlot, start with the Basic Usage Instructions below.  Then read the
usage.txt and jqPlotOptions.txt files included with the distribution.

The jqPlot home page is at <http://code.google.com/p/vklgraph/>.

Downloads can be found at <http://code.google.com/p/vklgraph/downloads/list>.

The mailing list is at <http://groups.google.com/group/vklgraph>.

Examples showcase are at <http://vkl-graph.appspot.com/>.

Documentation java is at <http://vkl-graph.appspot.com/docs/>.

Documentation is at <http://code.google.com/p/vklgraph/w/list>.

The source code are at <http://code.google.com/p/vklgraph/source/browse/>.

Bugs, issues, feature requests: <http://code.google.com/p/vklgraph/issues/list>.

Basic Usage Instructions:

vkgraph requires jqPlot (1.0+ required for certain features). jqPlot 1.0.0b2 is included in
the distribution. jqPlot requires jQuery (1.4+ required for certain features). jQuery 1.4.4 is included in 
the distribution.  

To use vkgraph include jqplot, jQuery, the jqPlot jQuery plugin, the jqPlot css file and 
optionally the excanvas script to support IE version prior to IE 9 in your web page:

> <!--[if lt IE 9]><script language="javascript" type="text/javascript" src="excanvas.js"></script><![endif]-->
> <script language="javascript" type="text/javascript" src="jquery-1.4.4.min.js"></script>
> <script language="javascript" type="text/javascript" src="jquery.jqplot.min.js"></script>
> <link rel="stylesheet" type="text/css" href="jquery.jqplot.css" />

For usage instructions, see <jqPlot Usage> in usage.txt.  For available options, see
<jqPlot Options> in jqPlotOptions.txt.

Building from source:

If you've cloned the repository, you can build a distribution from source.
You need to have maven <http://maven.apache.org/> installed.  You can simply 
type "maven clean install" from the vklgraph pom.xml directory to build the default "all" target.

Legal Notices:

Copyright (c) 20012-2013 Steeve Vandecappelle
vklgraph is currently available for use in all personal or commercial projects 
under the MIT license.

Although not required, the author would appreciate an email letting him 
know of any substantial use of vklgraph.  You can reach the author at: 
steeve dot vandecappelle at gmail dot com.

jqPlot includes date instance methods and printf/sprintf functions by other authors:

Date instance methods:

    author Ken Snyder (ken d snyder at gmail dot com)
    date 2008-09-10
    version 2.0.2 (http://kendsnyder.com/sandbox/date/)     
    license Creative Commons Attribution License 3.0 (http://creativecommons.org/licenses/by/3.0/)

JavaScript printf/sprintf functions.

    version 2007.04.27
    author Ash Searle
    http://hexmen.com/blog/2007/03/printf-sprintf/
    http://hexmen.com/js/sprintf.js
    The author (Ash Searle) has placed this code in the public domain:
    "This code is unrestricted: you are free to use it however you like."
