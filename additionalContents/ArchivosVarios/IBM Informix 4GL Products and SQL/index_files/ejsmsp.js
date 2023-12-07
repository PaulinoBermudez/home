function ReadCookieCVM(dcname) {
	var dcexist = dcname + "=";
	var dc = document.cookie;

	if (dc.length > 0) {
		offset = dc.indexOf(dcexist);
		if  (offset != -1) {
			offset += dcexist.length;
			end = dc.indexOf(";", offset);

			if (end == -1)  end = dc.length;

			return unescape(dc.substring(offset, end));
		}
	}

	return null;
}

function SetCookieCVM (dcname, value, expires, path, domain) {

	var secure=false;

	document.cookie = dcname

				+ "="

				+ escape(value)

				+ ((expires == null)?"":("; expires=" + expires.toGMTString()))

				+ ((path == null)?"":("; path=" + path))

				+ ((domain == null)?"":("; domain=" + domain))

				+ ((secure == true)?"; secure":"");
}

function DeleteCookieCVM (dcname) {
	var exp = new Date();
	exp.setTime(exp.getTime() - 1);
	var cval = ReadCookieCVM (dcname);

	SetCookieCVM(dcname, cval, exp);
}

function PUPCVM(query, currentUrl) {

	// query is the code for the module (V, W, H, S, SR, etc.)
	//var pupLoc = 'http://65.213.125.124/cgi-bin/ibm02/survpop.pl';
	var pupLoc = 'http://www.ibm.com/cgi-bin/survey/ibm02/survpop.pl';
	
	
	/*
	NoSuChStriNg - delimits the URL and the user starting time
	
	SlAsH  - replaces the / (sleshes) in the URL. This is needed as 
	         the survey.pl is removing these slashes and the URL is useless
	
	PLuSsS - replaces literal '+' if any, because otherwise survey.pl will 
	         run in test mode
	
	PeRCenT - replaces %
	
	all this is done here as survey.pl can not be changed without going
	trough some very lengthy check out
	*/
	
	var DateNow = new Date();
	var day = DateNow.getDay();
	var hour = DateNow.getHours();
	var	minute = DateNow.getMinutes();
	if(minute < 10){minute = "0" + minute; } 
	
	var	Utime = '' + hour + minute; 
	
	var http = pupLoc + '?' + query + '=' + currentUrl + 'NoSuChStriNg' + Utime;

	var w = 480;
	var h = 340;
	var g = 'width=' + w + ',height=' + h + ',top=0,left=30,scrollbars,status,resizable';
	var survey = window.open( http, "survey", g, 0);
	survey.focus();

}

// set these 
var cookieName = 'msp';
//var domainName = '172.18.1.124';
var domainName = '.ibm.com';
var expDays = 365;

var exp = new Date();
exp.setTime(exp.getTime() + (expDays*24*60*60*1000));

var valCookie = ReadCookieCVM(cookieName);

if ( !valCookie ) {

	var selectedModule, currentUrl, currentSearch, dynPat;
	var selectedRate, selectedINDEX;
	var modules, rates, moduleList;
	
	moduleList = ['V', 'G', 'M', 'S', 'SD', 'SV', 'SH', 'SR', 'TG', 'UL', 'W', 'WD', 'H', 'SL', 'PW']; 
	
	currentUrl = location.href;
	
	if( currentUrl.indexOf('?') >= 0 ){
		currentUrl = currentUrl.substr( 0, currentUrl.indexOf('?') );
	}
	
	currentSearch  = (location.search)?location.search:'';
	selectedModule = "";
	dynPat = '...';
	
	modules = new Object();

	/*
	modules[mod][i][0] - interception rate 0.2 = 20%
	modules[mod][i][1] - preset url
	modules[mod][i][2] - parameter
	modules[mod][i][3] - preset url id
	
	if the url starts with '...' the url is dynamic.

	modules.V  = [
		[ 0.2, 	 'www.url1.com/page2'],
		[ 0.3, 	 'www.url8.com/page4'],
		[ 0.0045,'www.url1.com/page8'],
		[ 0.02,  'www.url1.com/page3...'],
	];
	
	
	IE and Netscape treat the comma after the last element differently
	IE - modules.V.length is 5
	Netscape - modules.V.length is 4
	
	If the name of a static URL ends with folder there must be a '/' after 
	the folder name. 
	Then it will be compared to both the location.href and location.href + '/'
	*/

	modules.V  = [
		[1, 'http://www-106.ibm.com/developerworks/', , 1],
		[1, 'http://172.18.1.124/styles/dimitre/other.html', , 2],
		[1, 'http://bet.www.ibm.com/common/survey/test.html', , 2],
		[1, 'http://red.www.ibm.com/common/survey/test.html', , 2],
		[1, 'http://sch.www.ibm.com/common/survey/test.html', , 2],
		[1, 'http://www.ibm.com/common/survey/test.html', , 2],
		[1, 'http://ibm.com/common/survey/test.html', , 2],
		[1,''],
	];
	
	modules.ES  = [
		[0,'http://www-1.ibm.com/servers/solutions/', , 1],
		[0,'http://www.pc.ibm.com/us/eserver/xseries/index.html', , 2],
		[0,'...http://www-1.ibm.com/servers/eserver/linux/', , 3],
		[0,'http://www-1.ibm.com/servers/eserver/iseries/', , 4],
		[0,'http://www-1.ibm.com/servers/eserver/iseries/clientaccess/', , 5],
		[0,'http://www-1.ibm.com/servers/eserver/iseries/software/websphere/wsappserver/', , 6],
		[0,'http://www-1.ibm.com/servers/eserver/pseries/', , 7],
		[0,'http://www-1.ibm.com/servers/eserver/pseries/library/', , 8],
		[0,'http://www-1.ibm.com/servers/eserver/pseries/software/', , 9],
		[0,'http://www-1.ibm.com/servers/eserver/zseries/', , 10],
		[0,'http://www-1.ibm.com/servers/s390/os390/bkserv/', , 11],
		[0,'http://www-1.ibm.com/servers/s390/os390/', , 12],
		[0,'http://eistaging.nyc.ibm.com/common/survey/test.html', , 13],
		[0, '...http://wcs.haw.ibm.com/servers/solutions/', , 14],
		[0, ''],
	];
	
	modules.G  = [
		[1, 'http://www-1.ibm.com/services/', , 1],
		[1,''],
	];

	modules.M  = [
		[1, 'http://www-916.ibm.com/press/prnews.nsf/homepage', , 1],
		[1,''],
	];

	modules.S  = [
		[1,'http://www-4.ibm.com/software/', , 1],
		[1,'http://www-3.ibm.com/software/', , 2],
		[1,''],
	];

	modules.SD  = [
		[1,'http://www-4.ibm.com/software/data/', , 1],
		[1,'http://www-4.ibm.com/software/data/db2/', , 2],
		[1,'http://www-4.ibm.com/software/data/cm/', , 3],
		[1,'http://www-4.ibm.com/software/data/db2/udb/downloads.html', , 4],
		[1,'http://www-4.ibm.com/software/data/db2/os390/', , 5],
		[1,'http://www-4.ibm.com/software/data/ims/', , 6],		
		[1,'http://www-4.ibm.com/software/data/db2/udb/',, 7],
		[1,'http://www-4.ibm.com/software/data/informix/',, 8],
		[1,'http://www-4.ibm.com/software/data/u2/',, 9],
		[1,'http://www-4.ibm.com/software/data/bi/',, 10],
		[1,'http://www-3.ibm.com/software/data/', , 51],
		[1,'http://www-3.ibm.com/software/data/db2/', , 52],
		[1,'http://www-3.ibm.com/software/data/cm/', , 53],
		[1,'http://www-3.ibm.com/software/data/db2/udb/downloads.html', , 54],
		[1,'http://www-3.ibm.com/software/data/db2/os390/', , 55],
		[1,'http://www-3.ibm.com/software/data/ims/', , 56],		
		[1,'http://www-3.ibm.com/software/data/db2/udb/',, 57],
		[1,'http://www-3.ibm.com/software/data/informix/',, 58],
		[1,'http://www-3.ibm.com/software/data/u2/',, 59],
		[1,'http://www-3.ibm.com/software/data/bi/',, 60],
		
		[1,''],
	];

	modules.UL  = [
		[1,'http://www-3.ibm.com/services/learning/us/', , 1],
		[1,'http://twilite.sanjose.ibm.com/services/learning/us/index2.html', , 3],
		[1,''],
	];

	modules.SL  = [
		[1,'http://www.ibm.com/solutions/', , 1],
		[1,'http://www.ibm.com/solutions/industries/', , 2],
		[1,'http://www.ibm.com/solutions/us', , 3],
		[1,''],
	];

	modules.SR  = [
		[0.05,'...http://www.ibm.com/Search', , 1],
		[1,''],
	];

	modules.SV  = [
		[1, 'http://commerce.www.ibm.com/content/home/shop_ShopIBM/en_US/eServer/eServer.html',, 2],
		[1, 'http://www-1.ibm.com/servers/solutions/',, 3],
		[1, 'http://www.pc.ibm.com/us/eserver/xseries/index.html',, 4],
		[1, 'http://www-1.ibm.com/servers/eserver/linux/home.html',, 5],
		
		[1, 'http://www-1.ibm.com/servers/eserver/iseries/',, 10],
		[1, 'http://www-1.ibm.com/servers/eserver/iseries/clientaccess/',, 11],
		[1, 'http://www-1.ibm.com/servers/eserver/iseries/software/websphere/wsappserver/',, 12],
		
		[1, 'http://commerce.www.ibm.com/content/home/shop_ShopIBM/en_US/eServer/pSeries/pSeries.html',, 20],
		[1, 'http://www-1.ibm.com/servers/eserver/pseries/library/',, 21],
		[1, 'http://www-1.ibm.com/servers/eserver/pseries/software/',, 22],
		
		[1, 'http://www-1.ibm.com/servers/eserver/zseries/',, 30],
		[1, 'http://www-1.ibm.com/servers/s390/os390/bkserv/',, 31],
		[1, 'http://www-1.ibm.com/servers/s390/os390/',, 32],

		[1,''],
	];
	
	//can't use 2 and 20 for SH (these are used in SV)
	modules.SH  = [
		[0.2,'...http://commerce.www.ibm.com/', 'cntrfnbr=1', 1],
		[1,''],
	];

	modules.SB  = [
		[1,'http://www-1.ibm.com/businesscenter/us/smbusapub.nsf/detailcontacts/SBCenter59BB', , 1],
		[1,''],
	];

	modules.TG  = [
		[0.25,'http://www.storage.ibm.com/storagesmart/psa/index.htm', , 1],
		[0.25,'http://www.storage.ibm.com/storagesmart/psa/techsup.htm', , 2],
		[0.25,'http://www.storage.ibm.com/storagesmart/psa/news/psa_news.htm', , 3],
		[0.25,'http://www.storage.ibm.com/storagesmart/psa/library/psa_library.htm', , 4],
		[0.25,'http://www.storage.ibm.com/hdd/micro/index.htm', , 5],
		[0.25,'http://www.storage.ibm.com/hdd/micro/overvw.htm', , 6],
		[0.25,'http://www.storage.ibm.com/hdd/micro/soltns.htm', , 7],
		[0.25,'http://www.storage.ibm.com/hdd/index.htm', , 8],
		[0.25,'http://www.storage.ibm.com/hdd/support/index.htm', , 9],
		[0.25,'http://www.storage.ibm.com/hdd/prod/travelstar.htm', , 10],
		[0.25,'http://www.storage.ibm.com/hdd/prod/deskstar.htm', , 11],
		[0.25,'http://www.storage.ibm.com/hdd/prod/ultrastar.htm', , 12],
		[0.25,'http://www.storage.ibm.com/hdd/ultra/ul36z15.htm', , 13],
		[0.25,'http://www.storage.ibm.com/hdd/desk/ds60gxp.htm', , 14],
		[0.25,'http://www.storage.ibm.com/hdd/travel/tr60gh.htm', , 15],
		[0.25,'http://www.storage.ibm.com/hdd/hddpart.htm', , 16],
		[0.25,'http://www.storage.ibm.com/hdd/hddnews.htm', , 17],
		[0.25,'http://www.storage.ibm.com/hdd/hddlibry.htm', , 18],
		[0.25,'http://www.storage.ibm.com/hdd/hddhowto.htm', , 19],
		[0.25,'http://www.storage.ibm.com/hdd/firsts/index.htm', , 20],
		[0.25,'http://www.storage.ibm.com/hdd/technolo/grochows/grocho01.htm', , 21],
		[0.25,'http://www.storage.ibm.com/hdd/travel/tr40gn.htm', , 22],
		[1,'http://www-3.ibm.com/chips/products/', , 23],
		[1,'http://www-3.ibm.com/chips/services/asg/', , 24],
		[1,'http://www-3.ibm.com/chips/products/asics/', , 25],
		[1,'http://www-3.ibm.com/chips/products/interconnect/', , 26],
		[1,'http://www-3.ibm.com/chips/products/memory/', , 27],
		[1,'http://www-3.ibm.com/chips/products/digitalvideo/', , 28],
		[1,'http://www-3.ibm.com/chips/products/wired/', , 29],
		[1,'http://www-3.ibm.com/chips/products/design/', , 30],
		[1,'http://www-3.ibm.com/chips/products/infoapp/', , 31],
		[1,'http://www-3.ibm.com/chips/products/ipl/', , 32],
		[1,'http://www-3.ibm.com/chips/services/foundry/', , 33],
		[1,'http://www-3.ibm.com/chips/products/powerpc/', , 34],
		[1,'http://www-3.ibm.com/chips/products/settopbox/', , 35],
		[1,'http://www-3.ibm.com/chips/products/infiniband/', , 36],
		[1,'http://www-3.ibm.com/chips/products/wireless/', , 37],
		[1,''],
	];

	modules.PW  = [
		[1,'http://www.developer.ibm.com/', , 1],
		[1,''],
	];

	modules.W   = [
		[1,'http://www-3.ibm.com/software/info1/websphere/index.jsp', , 1],
		[1,'http://www-3.ibm.com/software/info1/websphere/wstechnology.jsp', , 2],
		[1,'http://www-3.ibm.com/software/info1/websphere/index.jsp', 'tab=products', 3],
		[1,'http://www-3.ibm.com/software/info1/websphere/platformoverview.jsp', , 4],
		[1,'http://www-3.ibm.com/software/info1/websphere/index.jsp', 'tab=appserver', 5],
		[1,'http://www-3.ibm.com/software/info1/websphere/index.jsp', 'tab=tools', 6],
		[1,'http://www-3.ibm.com/software/info1/websphere/index.jsp', 'tab=host', 7],
		[1,'http://www-3.ibm.com/software/info1/websphere/index.jsp', 'tab=commerce', 8],
		[1,'http://www-3.ibm.com/software/info1/websphere/index.jsp', 'tab=portal', 9],
		[1,'http://www-3.ibm.com/software/info1/websphere/index.jsp', 'tab=pervasive', 10],
		[1,'http://www-3.ibm.com/software/info1/websphere/index.jsp', 'tab=bpm', 11],
		[1,'http://www-3.ibm.com/software/info1/websphere/index.jsp', 'tab=infoconnect', 12],
		[1,'http://www-3.ibm.com/software/webservers/appserv/', , 13],
		[1,'http://www-3.ibm.com/software/ad/vajava/', , 14],
		[1,'http://www-3.ibm.com/software/ad/adstudio/', , 15],
		[1,'http://www-3.ibm.com/software/webservers/hostondemand/', , 16],
		[1,'http://www-3.ibm.com/software/webservers/commerce/', , 17],
		[1,'http://www-3.ibm.com/pvc/products/portal_server/index.shtml', , 18],
		[1,'http://www-3.ibm.com/software/speech/enterprise/ep_1.html', , 19],
	];

	modules.WD  = [
		[1,'http://www7b.boulder.ibm.com/wsdd/', , 1],
		[1,'http://www7b.software.ibm.com/wsdd/', , 2],
		[1,'http://www7b.boulder.ibm.com/wsdd/', , 3],
		[1,''],
	];

	modules.H   = [
		[0.4,'http://www.ibm.com/', , 1],
		[0.4,'http://www.ibm.com/products/', , 2],
		[0.4,''],
	];
	
	//Q must be the same as H
	modules.Q   = [
		[0.4,'http://www.ibm.com/', , 1],		
		[0.4,'http://www.ibm.com/products/', , 2],
		[0.4,''],
	];
	
	loopOne: for(modCount = 0; modCount < moduleList.length; modCount++){
	
		var mod = moduleList[modCount];

		if(!modules[mod].length) { continue;}

		loopTwo: for(i = 0; i < modules[mod].length; i++){
		
			if(!modules[mod][i]) continue loopTwo;
			if(!modules[mod][i][1]) continue loopTwo;
			
			if(modules[mod][i][1].indexOf(dynPat) >= 0){
			
				if(modules[mod][i][2] && currentSearch){
					if( currentSearch.indexOf( modules[mod][i][2] ) < 0 ){
						continue loopTwo;
					}
				}else if( modules[mod][i][2] ){
					continue loopTwo;
				}

				if( currentUrl.indexOf( modules[mod][i][1].substr(dynPat.length) ) == 0 ){

					selectedModule = mod;
					selectedRate   = modules[mod][i][0];
					selectedINDEX  = i;					

					break loopOne;
				}
			}else{
			
				if(modules[mod][i][2] && currentSearch){
					if( currentSearch.indexOf( modules[mod][i][2] ) < 0 ){
						continue loopTwo;
					}
				}else if( modules[mod][i][2] ){
					continue loopTwo;
				}

				if( 
					  ( currentUrl == modules[mod][i][1] )
					||( (currentUrl + '/') == modules[mod][i][1] )	
					||( currentUrl == (modules[mod][i][1] + '/') )
				
				  ){

					selectedModule = mod;
					selectedRate   = modules[mod][i][0];
					selectedINDEX  = i;

					break loopOne;
				}
			}
		}
	}

	if ( (selectedModule != '') && ( Math.random() < selectedRate) ){

		valCookie = 2;
		DeleteCookieCVM(cookieName);
		SetCookieCVM(cookieName, valCookie, exp, '/', domainName);
		
		//exceptions
		
		if( selectedModule == 'H' ){
			if ( Math.random() < 0.8 ){
				selectedModule = 'Q'; //half the people from H get Q
			}
		}
		
		if( (selectedModule == 'SV') 
			&& ( 
				( modules[selectedModule][selectedINDEX][3] == 2)
			  ||( modules[selectedModule][selectedINDEX][3] == 20)
			  )
		  ){
		  	if( Math.random() < 0.1 ){
		  		selectedModule = 'SH'; // 1:9 ( SH:SV) for SV urls 2 and 20
		  	}
		}		
		
		//end exceptions
		
		if( ReadCookieCVM(cookieName) ){ //( document.cookie ){ // if browser is set for no cookies don't pop up
			PUPCVM( selectedModule, modules[selectedModule][selectedINDEX][3] );
		}
	}
}

