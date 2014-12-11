var git = require("gift"),
	logger = require("log4js").getLogger("fetch"),
	fs = require("fs"),
	readline = require('readline'),
	temp = require("temp"),
	_ = require("underscore"),
	ncp = require("ncp"),
	rmdir = require("rmdir");

var repoPath = __dirname.concat('/vkl-graph-deps');
var repUrl = "https://github.com/svandecappelle/jQPlot";
var destinationPath = __dirname.concat("/src/main/resources/fr/vekia/VkGraph/public/jqplot/");

logger.info("Fetching jQplot source repository");

checkout();

function checkout(){
	if(fs.existsSync(repoPath)){
		connectRepo();
	}else{
		clone();
	}
};

function connectRepo(){
	var repository = git(repoPath);
	listTags(repository);
};

function clone(){
	logger.info("Cloning " + repUrl + " into " + repoPath);
	git.clone(repUrl, repoPath, function (err, repository){
		if (err){
			logger.error("Error cloning repository", err);
			return;
		}
		listTags(repository);
	});
};

function listTags(repo){
	repo.tags(function (err, tags){
		if(tags.length > 0){
			tags = _.pluck(tags, "name");
			tags.push('master[current]');
			logger.info("Tags available:", tags.join(' | '));
			askForTag(repo);
		}else{
			// master only
			logger.warn("There is no tags released. Using the master");
			lastCheck();
		}
	});
};

function lastCheck(){
	var rl = readline.createInterface({
		input: process.stdin,
		output: process.stdout
	});

	rl.question("Are you sure to switch jQplot sources on this tag-release (cannot be undone) ? Y/n ", function (sure) {
		rl.close();
		if (sure === 'Y' || sure === 'y'){
			mergeSources();
		}else{
			logger.info("Cancelled");
		}
	});
};

function mergeSources(){
	logger.info("Merging sources");
	if (fs.existsSync(destinationPath)){
		rmdir(destinationPath, function (err, dirs, files){
			if (err){
				return logger.error("Error merging files", err);
			}

			copySrcs();
		});
	}else{
		copySrcs();
	}
};

function copySrcs(){
	ncp.ncp(repoPath.concat('/build/dist/'), destinationPath, function (err){
		if (err){
			return logger.error("Error merging sources", err);
		}
		logger.info("Source merged");

		var rl = readline.createInterface({
			input: process.stdin,
			output: process.stdout
		});

		rl.question("Cleaning working dir ? Y/n ", function (sure) {
			rl.close();
			if (sure === 'Y' || sure === 'y'){
				cleanup();
				logger.info("Cleaning sources");
			}
		});
		
	});
}

function cleanup(){
	rmdir(repoPath, function (err, dirs, files){
		if (err){
			return logger.error("Error merging files", err);
		}

		logger.info("Working dir cleaned");
	});
};

function askForTag(repo){

	var rl = readline.createInterface({
		input: process.stdin,
		output: process.stdout
	});

	rl.question("Choose a tag ? ", function (tagToSwitch) {
		rl.close();
		var tag = tagToSwitch.trim();
		logger.info("Switching to", tag);

		// check if tag selected
		if (!tag){
			tag = 'master';
		}

		repo.checkout(tag, function (err, output){
			if(err){
				logger.error("Error switching tag", err);
			}
			logger.info("Switched.");
			lastCheck();
		});
	});
};