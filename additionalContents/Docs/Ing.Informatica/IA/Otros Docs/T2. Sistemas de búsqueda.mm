<map version="1.0.1">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node CREATED="1495294012901" ID="ID_1635386240" MODIFIED="1495362567377" TEXT="B&#xfa;squeda no informada">
<node CREATED="1495294051339" ID="ID_17455169" MODIFIED="1495310409730" POSITION="right" TEXT="Espacio de b&#xfa;squeda">
<font BOLD="true" NAME="Verdana" SIZE="10"/>
<node CREATED="1495310551319" ID="ID_565720729" MODIFIED="1495310557859" TEXT="Grafo dirigido simple"/>
<node CREATED="1495294061131" ID="ID_941339484" MODIFIED="1495294064736" TEXT="Estados">
<node CREATED="1495294194483" ID="ID_1676771596" MODIFIED="1495294208119" TEXT="Situaciones posibles en el problema"/>
<node CREATED="1495310600279" ID="ID_400193142" MODIFIED="1495310603308" TEXT="Inicial">
<node CREATED="1495310624335" ID="ID_39354835" MODIFIED="1495310633484" TEXT="En el que comienza la b&#xfa;squeda"/>
</node>
<node CREATED="1495294222276" ID="ID_125015984" MODIFIED="1495294229095" TEXT="Meta">
<node CREATED="1495294230354" ID="ID_1066990469" MODIFIED="1495310658467" TEXT="Cada uno de los estados soluci&#xf3;n"/>
</node>
</node>
<node CREATED="1495294065292" ID="ID_588822948" MODIFIED="1495294068160" TEXT="Operadores">
<node CREATED="1495294069963" ID="ID_1979927891" MODIFIED="1495294118168" TEXT="Acci&#xf3;n elemental que permite cambiar de estado"/>
<node CREATED="1495294119436" ID="ID_215520589" MODIFIED="1495294181687" TEXT="Estado origen - Estado destino - Coste"/>
</node>
<node CREATED="1495297750030" ID="ID_1969307889" MODIFIED="1495297766064" TEXT="Tama&#xf1;o del problema">
<node CREATED="1495297883364" ID="ID_325212023" MODIFIED="1495314005827" TEXT="n">
<font BOLD="true" NAME="Verdana" SIZE="10"/>
<node CREATED="1495297775284" ID="ID_1047680107" MODIFIED="1495297989418" TEXT="Factor de ramificaci&#xf3;n">
<node CREATED="1495297913532" ID="ID_712171880" MODIFIED="1495297964336" TEXT="N&#xba; medio de sucesores de los nodos del &#xe1;rbol de b&#xfa;squeda"/>
</node>
</node>
<node CREATED="1495297821092" ID="ID_403120585" MODIFIED="1495314010851" TEXT="p">
<font BOLD="true" NAME="Verdana" SIZE="10"/>
<node CREATED="1495297929068" ID="ID_1330487835" MODIFIED="1495297987089" TEXT="Profundidad de la soluci&#xf3;n">
<node CREATED="1495297940004" ID="ID_1589569600" MODIFIED="1495297952080" TEXT="N&#xba; de arcos desde el nodo inicial hasta la soluci&#xf3;n, que se supone &#xfa;nica"/>
</node>
</node>
</node>
</node>
<node CREATED="1495310253480" ID="ID_1543907240" MODIFIED="1495310412234" POSITION="right" TEXT="Estragia de control">
<font BOLD="true" NAME="Verdana" SIZE="10"/>
<node CREATED="1495310334527" ID="ID_992705678" MODIFIED="1495310351379" TEXT="Determina el orden en el que se recorre el espacio de b&#xfa;squeda"/>
<node CREATED="1495310372695" ID="ID_439832988" MODIFIED="1495310376939" TEXT="Caracter&#xed;sticas">
<node CREATED="1495295981068" ID="ID_1194822300" MODIFIED="1495361984064" TEXT="Completitud">
<font BOLD="true" NAME="Verdana" SIZE="10"/>
<node CREATED="1495296059987" ID="ID_204799995" MODIFIED="1495296069416" TEXT="Siempre encuentra soluci&#xf3;n"/>
</node>
<node CREATED="1495295986475" ID="ID_504890615" MODIFIED="1495361984064" TEXT="Admisibilidad">
<font BOLD="true" NAME="Verdana" SIZE="10"/>
<node CREATED="1495296079691" ID="ID_1855899451" MODIFIED="1495296095192" TEXT="Siempre encuentra una soluci&#xf3;n &#xf3;ptima"/>
</node>
</node>
<node CREATED="1495326599899" ID="ID_662105301" MODIFIED="1495362513361" TEXT="B&#xfa;squeda en &#xe1;rboles">
<node CREATED="1495325275051" ID="ID_1383886547" MODIFIED="1495325285007" TEXT="AGBA">
<node CREATED="1495325286795" ID="ID_689667151" MODIFIED="1495326573018" TEXT="Algoritmo general de b&#xfa;squeda en &#xe1;rboles">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <pre>ABIERTA = (inicial);
<b><font color="#0033ff">mientras</font></b>&#160;NoVacia(ABIERTA) <b><font color="#0033ff">hacer</font></b>
&#x9;n = ExtraePrimero(ABIERTA);
&#x9;<b><font color="#0033ff">si</font></b> EsObjetivo(n) <b><font color="#0033ff">entonces</font></b>
&#x9;&#x9;<b><font color="#0033ff">devolver</font></b> Camino(inicial, n); {ley&#233;ndolo en TABLA_A}
&#x9;<b><font color="#0033ff">fin si</font></b>
&#x9;S = Sucesores(n);
&#x9;<b><font color="#0033ff">para</font></b> cada q de S <b><font color="#0033ff">hacer</font></b>
&#x9;&#x9;pone q en TABLA_A con
&#x9;&#x9;&#x9;Anterior(q) = n,
&#x9;&#x9;&#x9;Coste(inicial, q) = Coste(inicial, n) + Coste(n, q);
&#x9;&#x9;inserta q en ABIERTA;
&#x9;<b><font color="#0033ff">fin para</font></b>
<b><font color="#0033ff">fin mientras</font></b>
<b><font color="#0033ff">devolver</font></b> &quot;no encontrado&quot;;
    </pre>
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1495294430050" ID="ID_1200213073" MODIFIED="1495360786638" TEXT="Primero en anchura">
<node CREATED="1495325917515" ID="ID_115165509" MODIFIED="1495325923784" TEXT="Exploraci&#xf3;n por niveles"/>
<node CREATED="1495296468347" ID="ID_548046032" MODIFIED="1495296789730" TEXT="ABIERTA es una cola"/>
<node CREATED="1495296284531" ID="ID_1075194487" MODIFIED="1495296363833" TEXT="Completo">
<icon BUILTIN="button_ok"/>
</node>
<node CREATED="1495296298803" ID="ID_1928405515" MODIFIED="1495298017696" TEXT="Admisible (si todos los arcos a igual profundidad, tienen el mismo coste)">
<icon BUILTIN="info"/>
</node>
<node CREATED="1495297343916" ID="ID_55987494" MODIFIED="1495297349472" TEXT="Coste temporal">
<node CREATED="1495297357636" ID="ID_854768612" MODIFIED="1495310923303">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      O(n<sup>p</sup>)
    </p>
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1495297349884" ID="ID_932132774" MODIFIED="1495297353505" TEXT="Coste espacial">
<node CREATED="1495297420044" ID="ID_912737634" MODIFIED="1495310979327">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      O(n<sup>p</sup>)
    </p>
  </body>
</html></richcontent>
</node>
</node>
</node>
<node CREATED="1495294436539" ID="ID_1729321123" MODIFIED="1495361984064" TEXT="Primero en profundidad">
<node CREATED="1495296482755" ID="ID_576536567" MODIFIED="1495527938490" TEXT="ABIERTA es una pila"/>
<node CREATED="1495296115700" ID="ID_1175524111" MODIFIED="1495296367727" TEXT="No completo">
<icon BUILTIN="button_cancel"/>
<node CREATED="1495310716255" ID="ID_1476095344" MODIFIED="1495310725545" TEXT="No admisible">
<icon BUILTIN="button_cancel"/>
</node>
</node>
<node CREATED="1495310766743" ID="ID_1097846495" MODIFIED="1495310771755" TEXT="Coste temporal">
<node CREATED="1495310778607" ID="ID_485622810" MODIFIED="1495310995007">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      O(n<sup>p</sup>)
    </p>
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1495310772383" ID="ID_325032570" MODIFIED="1495310776748" TEXT="Coste espacial">
<node CREATED="1495310790399" ID="ID_152022870" MODIFIED="1495310800028" TEXT="O(n &#xb7; p)"/>
</node>
</node>
<node CREATED="1495294442787" ID="ID_1184996853" MODIFIED="1495361984079" TEXT="Coste uniforme">
<node CREATED="1495324434715" ID="ID_98911785" MODIFIED="1495324478143" TEXT="ABIERTA se ordena seg&#xfa;n el coste del camino desde el nodo inicial a cada nodo"/>
<node CREATED="1495324338714" ID="ID_937449087" MODIFIED="1495324371055" TEXT="Si el coste de todos los operadores es el mismo, equivale al recorrido primero en anchura"/>
<node CREATED="1495325969955" ID="ID_459117979" MODIFIED="1495325995270" TEXT="Completo">
<icon BUILTIN="button_ok"/>
</node>
<node CREATED="1495325975251" ID="ID_1102998775" MODIFIED="1495325998238" TEXT="Admisible">
<icon BUILTIN="button_ok"/>
</node>
<node CREATED="1495313966593" ID="ID_1252847021" MODIFIED="1495313970749" TEXT="Coste temporal">
<node CREATED="1495310778607" ID="ID_1890699143" MODIFIED="1495310995007">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      O(n<sup>p</sup>)
    </p>
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1495310816567" ID="ID_533623136" MODIFIED="1495310820524" TEXT="Coste espacial">
<node CREATED="1495310821975" ID="ID_256339822" MODIFIED="1495326335683">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      O(n<sup>p</sup>)
    </p>
  </body>
</html></richcontent>
</node>
</node>
</node>
<node CREATED="1495294450027" ID="ID_1053400085" MODIFIED="1495361984079" TEXT="Anchura iterativa">
<node CREATED="1495324579554" ID="ID_442093157" MODIFIED="1495324635768" TEXT="Usa AnchuraLimite para controlar el n&#xba; max. de hijos generados por cada padre"/>
<node CREATED="1495326061787" ID="ID_395945949" MODIFIED="1495326074478" TEXT="Completo">
<icon BUILTIN="button_ok"/>
</node>
<node CREATED="1495326066220" ID="ID_313898860" MODIFIED="1495326079301" TEXT="No admisible">
<icon BUILTIN="button_cancel"/>
</node>
<node CREATED="1495297343916" ID="ID_1104650578" MODIFIED="1495297349472" TEXT="Coste temporal">
<node CREATED="1495297357636" ID="ID_1960292510" MODIFIED="1495310923303">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      O(n<sup>p</sup>)
    </p>
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1495297349884" ID="ID_495866560" MODIFIED="1495297353505" TEXT="Coste espacial">
<node CREATED="1495297420044" ID="ID_158249541" MODIFIED="1495310979327">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      O(n<sup>p</sup>)
    </p>
  </body>
</html></richcontent>
</node>
</node>
</node>
<node CREATED="1495294457011" ID="ID_904271377" MODIFIED="1495361984095" TEXT="Profundidad iterativa">
<node CREATED="1495326150075" ID="ID_552411226" MODIFIED="1495326166959" TEXT="Establece una profundidad l&#xed;mite para cada iteraci&#xf3;n"/>
<node CREATED="1495326224251" ID="ID_239860403" MODIFIED="1495326247232" TEXT="En cada iteraci&#xf3;n hay que volver a visitar los nodos visitados en la iteraci&#xf3;n anterior"/>
<node CREATED="1495313895609" ID="ID_1254161728" MODIFIED="1495313957723" TEXT="Completo">
<icon BUILTIN="button_ok"/>
</node>
<node CREATED="1495313902208" ID="ID_658675522" MODIFIED="1495324561255" TEXT="Admisible (si todos los arcos tienen el mismo coste)">
<icon BUILTIN="info"/>
</node>
<node CREATED="1495313966593" ID="ID_156344129" MODIFIED="1495313970749" TEXT="Coste temporal">
<node CREATED="1495310778607" ID="ID_1902890664" MODIFIED="1495310995007">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      O(n<sup>p</sup>)
    </p>
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1495313971208" ID="ID_1832357686" MODIFIED="1495313975733" TEXT="Coste espacial">
<node CREATED="1495310790399" ID="ID_517387274" MODIFIED="1495310800028" TEXT="O(n &#xb7; p)"/>
</node>
</node>
<node CREATED="1495296581283" ID="ID_53038170" MODIFIED="1495361984095" TEXT="Bidireccional">
<node CREATED="1495296620427" ID="ID_517379663" MODIFIED="1495296735032" TEXT="Completa (si uno de los recorridos es en anchura)">
<icon BUILTIN="info"/>
</node>
<node CREATED="1495296658131" ID="ID_12528052" MODIFIED="1495296706384" TEXT="Admisible (si es completa, y se busca desde todos los nodos meta)">
<icon BUILTIN="info"/>
</node>
<node CREATED="1495310809646" ID="ID_1490581720" MODIFIED="1495310815908" TEXT="Coste temporal">
<node CREATED="1495310821975" ID="ID_974807878" MODIFIED="1495310894651">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      O(n<sup>p/2</sup>)
    </p>
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1495310816567" ID="ID_381011125" MODIFIED="1495310820524" TEXT="Coste espacial">
<node CREATED="1495310821975" ID="ID_657384734" MODIFIED="1495310894651">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      O(n<sup>p/2</sup>)
    </p>
  </body>
</html></richcontent>
</node>
</node>
</node>
</node>
<node CREATED="1495326660643" ID="ID_796691226" MODIFIED="1495361984095" TEXT="B&#xfa;squeda en grafos">
<icon BUILTIN="messagebox_warning"/>
<node CREATED="1495326744627" ID="ID_1924373033" MODIFIED="1495326749536" TEXT="AGBG">
<node CREATED="1495326751548" ID="ID_1500743882" MODIFIED="1495327224300" TEXT="Algoritmo general de b&#xfa;squeda en grafos">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <pre>ABIERTA = (inicial);
<b><font color="#0033ff">mientras</font></b>&#160;NoVacia(ABIERTA) <b><font color="#0033ff">hacer</font></b>
&#x9;n = ExtraePrimero(ABIERTA);
&#x9;<b><font color="#0033ff">si</font></b> EsObjetivo(n) <b><font color="#0033ff">entonces</font></b>
&#x9;&#x9;<b><font color="#0033ff">devolver</font></b> Camino(inicial, n); {ley&#233;ndolo en TABLA_A}
&#x9;<b><font color="#0033ff">fin si</font></b>
&#x9;S = Sucesores(n);
&#x9;A&#241;ade S a la entrada de n en la TABLA_A;
&#x9;<b><font color="#0033ff">para</font></b> cada q de S <b><font color="#0033ff">hacer</font></b>
&#x9;&#x9;<b><font color="#0033ff">si</font></b> q en TABLA_A <b><font color="#0033ff">entonces</font></b>
&#x9;&#x9;&#x9;Rectificar(q, n, Coste(n, q));
&#x9;&#x9;&#x9;Ordenar(ABIERTA); {si es preciso}
&#x9;&#x9;<b><font color="#0033ff">si no</font></b>
&#x9;&#x9;&#x9;pone q en la TABLA_A con
&#x9;&#x9;&#x9;&#x9;Anterior(q) = n,
&#x9;&#x9;&#x9;&#x9;Coste(inicial, q) = Coste(inicial, n) + Coste(n, q);
&#x9;&#x9;&#x9;ABIERTA = Mezclar(q, ABIERTA);
&#x9;&#x9;<b><font color="#0033ff">fin si</font></b>
&#x9;<b><font color="#0033ff">fin para</font></b>
<b><font color="#0033ff">fin mientras</font></b>
<b><font color="#0033ff">devolver</font></b> &quot;no soluci&#243;n&quot;;
    </pre>
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1495327293892" ID="ID_318764262" MODIFIED="1495327346128" TEXT="Para digrafos simples, cada arco tiene coste no negativo."/>
<node CREATED="1495327346948" ID="ID_62292085" MODIFIED="1495327393416" TEXT="El digrafo debe ser localmente finito (n&#xba; finito de sucesores de cada nodo)"/>
</node>
</node>
</node>
</map>
