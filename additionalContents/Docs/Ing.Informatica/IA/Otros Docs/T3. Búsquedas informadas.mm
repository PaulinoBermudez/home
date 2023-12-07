<map version="1.0.1">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node CREATED="1495362164555" ID="ID_386798038" MODIFIED="1495362408131" TEXT="B&#xfa;squedas informadas">
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
<node CREATED="1495362322671" ID="ID_670578841" MODIFIED="1495362328537" TEXT="Heur&#xed;stico">
<node CREATED="1495362329694" ID="ID_885737323" MODIFIED="1495362390047" TEXT="Informaci&#xf3;n asociada a cada nodo para facilitar la b&#xfa;squeda del estado meta &#xf3;ptimo"/>
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
<node CREATED="1495296396619" ID="ID_627680964" MODIFIED="1495362289312" TEXT="Primero el mejor (BF)">
<icon BUILTIN="messagebox_warning"/>
<node CREATED="1495327830372" ID="ID_688681599" MODIFIED="1495327886864" TEXT="Variante del AGBG que usa una funci&#xf3;n de evaluaci&#xf3;n f(n) que indica lo prometedor que es el nodo"/>
<node CREATED="1495327931876" ID="ID_822824803" MODIFIED="1495327935912" TEXT="f(n)">
<node CREATED="1495327936908" ID="ID_1553484730" MODIFIED="1495327945913" TEXT="Funci&#xf3;n heur&#xed;stica de evaluaci&#xf3;n"/>
</node>
<node CREATED="1495327891444" ID="ID_540741892" MODIFIED="1495327897649" TEXT="ABIERTA">
<node CREATED="1495327898780" ID="ID_1384845003" MODIFIED="1495327906152" TEXT="Se ordena por f(n)"/>
</node>
<node CREATED="1495327985484" ID="ID_614382406" MODIFIED="1495357941353" TEXT="Completo (en grafos finitos)">
<icon BUILTIN="button_ok"/>
</node>
<node CREATED="1495328021756" ID="ID_1930810478" MODIFIED="1495328029798" TEXT="No admisible">
<icon BUILTIN="button_cancel"/>
</node>
</node>
<node CREATED="1495296402132" ID="ID_532929060" MODIFIED="1495362289343" TEXT="A*">
<font BOLD="true" NAME="Verdana" SIZE="10"/>
<node CREATED="1495327742588" ID="ID_963096642" MODIFIED="1495328079113" TEXT="Especializci&#xf3;n de BF"/>
<node CREATED="1495328115900" ID="ID_1022991580" MODIFIED="1495361984110" TEXT="f*(n) = g*(n) + h*(n)">
<node CREATED="1495357456518" ID="ID_1397734676" MODIFIED="1495357512045" TEXT="f* = coste del camino m&#xe1;s corto desde el nodo inicial a los nodos objetivos, condicionado a pasar por n"/>
<node CREATED="1495357517524" ID="ID_926897069" MODIFIED="1495357582280" TEXT="g* = coste del camino m&#xe1;s corto que existe desde el nodo inicial a n"/>
<node CREATED="1495357592140" ID="ID_1263111744" MODIFIED="1495357628873" TEXT="h* = coste del camino m&#xe1;s corto que existe desde el nodo objetivo m&#xe1;s cercano a n"/>
<node CREATED="1495357705316" ID="ID_1634319436" MODIFIED="1495357751619" TEXT="C* = f*(inicial) = h*(inicial) = coste de la soluci&#xf3;n &#xf3;ptima"/>
</node>
<node CREATED="1495311459760" ID="ID_750789541" MODIFIED="1495361984110" TEXT="f(n) = g(n) + h(n)">
<node CREATED="1495357785964" ID="ID_1389846416" MODIFIED="1495357816548" TEXT="f = estimaci&#xf3;n de f*. Criterio para ordenar ABIERTA"/>
<node CREATED="1495311475343" ID="ID_1222646481" MODIFIED="1495311503483" TEXT="g = coste del camino desde el nodo inicial a n"/>
<node CREATED="1495311521743" ID="ID_1998536170" MODIFIED="1495311543268" TEXT="h = funci&#xf3;n heur&#xed;stica que estima el coste para llegar a meta pasando por n">
<node CREATED="1495322642346" ID="ID_702892159" MODIFIED="1495322960262" TEXT="es mon&#xf3;tona si V(n,n&apos;), h(n) &#x2264; k(n,n&apos;) + h(n&apos;) (k(n,n&apos;) es el menor coste para ir de n a n&apos;)"/>
<node CREATED="1495358680940" ID="ID_672851288" MODIFIED="1495358873986" TEXT="es consistente si V(n,n&apos;), h(n) &#x2264; c(n,n&apos;) + h(n&apos;) (c(n,n&apos;) es el coste de la regla que lleva de n a n&apos;, &#x221e; si no existe)"/>
<node CREATED="1495358882764" ID="ID_972133009" MODIFIED="1495358908648" TEXT="monoton&#xed;a y consistencia son equivalentes"/>
<node CREATED="1495358909165" ID="ID_31078085" MODIFIED="1495358934667" TEXT="todo heur&#xed;stico mon&#xf3;tono es admisible"/>
</node>
</node>
<node CREATED="1495358196268" ID="ID_1422290854" MODIFIED="1495358225441" TEXT="Condici&#xf3;n necesaria para expandir n es que f(n) &#x2264; C*"/>
<node CREATED="1495323605586" ID="ID_277860078" MODIFIED="1495361984110" TEXT="Al expandir n y generar cada uno de sus hijos (q)">
<node CREATED="1495323671282" ID="ID_193421618" MODIFIED="1495323828735" TEXT="Si q no est&#xe1; en TABLA_A, se mete. Se marca n como mejor padre, se calcula g(q) = g(n) + k(n,q), y es introducido en ABIERTA seg&#xfa;n f(q)"/>
<node CREATED="1495323831523" ID="ID_1405330725" MODIFIED="1495324193551" TEXT="Si q estaba en TABLA_A y su lista de hijos es vac&#xed;a (no expandido), rectificar g(q). Si es as&#xed;, reorientar al nuevo padre en TABLA_A, y evaluar un posible cambio de orden en ABIERTA."/>
<node CREATED="1495323967626" ID="ID_1786835328" MODIFIED="1495324009127" TEXT="Si q estaba en TABLA_A y su lista de hijos no es vac&#xed;a (ya expandido)">
<node CREATED="1495324010346" ID="ID_1824693868" MODIFIED="1495324040391" TEXT="rectificar g(q)??"/>
<node CREATED="1495324068427" ID="ID_451539036" MODIFIED="1495324236663" TEXT="Si hay que rectificar, habr&#xe1; que evaluar recursivamente en descendientes para actualizar TABLA_A, y de ser necesario, cambiar orden en ABIERTA"/>
</node>
</node>
<node CREATED="1495358003100" ID="ID_1686951480" MODIFIED="1495358182775" TEXT="Completo (en grafos localmente finitos)">
<icon BUILTIN="info"/>
</node>
<node CREATED="1495358047956" ID="ID_1746082113" MODIFIED="1495358174885" TEXT="Admisible (siempre que h sea admisible: Vn, h(n) &#x2264; h*(n))">
<icon BUILTIN="info"/>
</node>
<node CREATED="1495359009900" ID="ID_579680618" MODIFIED="1495361984126" TEXT="Relajaci&#xf3;n de condiciones de optimalidad">
<node CREATED="1495359129333" ID="ID_711583916" MODIFIED="1495359223363" TEXT="Cuando A* dedica demasiado tiempo discriminando caminos cuyos costes no var&#xed;an significativamente, se puede ganar en eficiencia a costa de perder en admisibilidad"/>
<node CREATED="1495359047421" ID="ID_387177347" MODIFIED="1495359057168" TEXT="Ajuste de pesos de g y h">
<node CREATED="1495359261725" ID="ID_10170406" MODIFIED="1495359334089" TEXT="f(n) = (1-w)g(n) + w &#xb7; h(n), 0 &#x2264; w &#x2264; 1"/>
<node CREATED="1495359339021" ID="ID_1486887727" MODIFIED="1495359369742" TEXT="w  = 0 &#x2261; coste uniforme"/>
<node CREATED="1495359374476" ID="ID_328242370" MODIFIED="1495359393814" TEXT="w = 1/2 &#x2261; A* est&#xe1;ndar"/>
<node CREATED="1495359394885" ID="ID_1543682394" MODIFIED="1495359405168" TEXT="w = 1 &#x2261; BF"/>
<node CREATED="1495359428262" ID="ID_1939880731" MODIFIED="1495359440338" TEXT="El mejor w se obtiene de forma experimental"/>
</node>
<node CREATED="1495359081564" ID="ID_151364036" MODIFIED="1495359090115" TEXT="Algoritmos &#x3b5;-admisibles">
<node CREATED="1495359871189" ID="ID_1043195387" MODIFIED="1495359969232" TEXT="Un algoritmo es &#x3b5;-admisible si siempre encuentra una soluci&#xf3;n con un coste &#x2264; (1+ &#x3b5;)C*"/>
<node CREATED="1495296964140" ID="ID_1286544245" MODIFIED="1495324950789" TEXT="Ponderaci&#xf3;n din&#xe1;mica">
<icon BUILTIN="messagebox_warning"/>
<node CREATED="1495359481069" ID="ID_1557585384" MODIFIED="1495359497088" TEXT="los pesos cambian a lo largo del proceso de b&#xfa;squeda"/>
<node CREATED="1495360001181" ID="ID_1517253446" MODIFIED="1495360062372" TEXT="h tiene mayor peso al principio de la b&#xfa;squeda. En las proximidades de la soluci&#xf3;n se pasa a b&#xfa;squeda en anchura"/>
<node CREATED="1495360063181" ID="ID_1998426996" MODIFIED="1495360123233" TEXT="f(n) = g(n) + h(n) + &#x3b5;(1 - d(n) / N)h(n)"/>
<node CREATED="1495360126053" ID="ID_1382840122" MODIFIED="1495360146248" TEXT="d(n) = profundidad del nodo n"/>
<node CREATED="1495360150933" ID="ID_10149244" MODIFIED="1495360165857" TEXT="N = cota superior de profundidad de la mejor soluci&#xf3;n"/>
<node CREATED="1495360177606" ID="ID_1552075757" MODIFIED="1495360198322" TEXT="Si h es admisible, la ponderaci&#xf3;n din&#xe1;mica es &#x3b5;-admisible"/>
</node>
<node CREATED="1495296994300" ID="ID_1835659143" MODIFIED="1495324954269" TEXT="A&#x3b5;*">
<icon BUILTIN="messagebox_warning"/>
<node CREATED="1495359539261" ID="ID_730933421" MODIFIED="1495360374592" TEXT="Utilizan una funci&#xf3;n heur&#xed;stica adicional para seleccionar nodos de una sublista de ABIERTA (nodos con f &#x2264; (1 + &#x3b5;) min(f en ABIERTA) llamada FOCAL"/>
<node CREATED="1495360216941" ID="ID_1412871217" MODIFIED="1495360434845" TEXT="Estrategia id&#xe9;ntica que A*, salvo que se desarrollan primero los nodos de FOCAL seg&#xfa;n los valores del segundo heur&#xed;stico h&apos;"/>
<node CREATED="1495360442605" ID="ID_1348706575" MODIFIED="1495360473171" TEXT="h&apos; = estimaci&#xf3;n del esfuerzo computacional para llegar desde n a la soluci&#xf3;n"/>
<node CREATED="1495360177606" ID="ID_967821432" MODIFIED="1495360518653" TEXT="Si h es admisible, A&#x3b5;* es &#x3b5;-admisible"/>
</node>
</node>
</node>
<node CREATED="1495297089123" ID="ID_1787819386" MODIFIED="1495297096400" TEXT="Conservaci&#xf3;n de memoria">
<node CREATED="1495297097516" ID="ID_1463155766" MODIFIED="1495297101160" TEXT="IDA*">
<node CREATED="1495311189055" ID="ID_933302621" MODIFIED="1495315227310" TEXT="Iterative Deepening A* (1985)"/>
<node CREATED="1495311251535" ID="ID_1322860028" MODIFIED="1495316481030" TEXT="Amplia b&#xfa;squeda en profundidad iterativa"/>
<node CREATED="1495316392017" ID="ID_1587899049" MODIFIED="1495316456182" TEXT="En cada iteraci&#xf3;n, coste l&#xed;mite para la b&#xfa;squeda (min(f) de los nodos descartados)"/>
<node CREATED="1495315295161" ID="ID_1534149555" MODIFIED="1495315299629" TEXT="ABIERTA">
<node CREATED="1495315307976" ID="ID_263583524" MODIFIED="1495315310557" TEXT="pila"/>
</node>
<node CREATED="1495316686129" ID="ID_92216582" MODIFIED="1495316692779" TEXT="Completo">
<icon BUILTIN="button_ok"/>
</node>
<node CREATED="1495311437328" ID="ID_574948246" MODIFIED="1495316376036" TEXT="Admisible (si h es admisible)">
<icon BUILTIN="info"/>
</node>
<node CREATED="1495360752981" ID="ID_1211032570" MODIFIED="1495360758906" TEXT="Coste temporal">
<node CREATED="1495297357636" ID="ID_1269138540" MODIFIED="1495310923303">
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
<node CREATED="1495360710405" ID="ID_740514973" MODIFIED="1495360716024" TEXT="Coste espacial">
<node CREATED="1495360717733" ID="ID_387326042" MODIFIED="1495360730764" TEXT="O(n &#xb7; p)"/>
</node>
</node>
<node CREATED="1495297101707" ID="ID_1666501812" MODIFIED="1495297105416" TEXT="SMA*">
<node CREATED="1495315266249" ID="ID_707624753" MODIFIED="1495315279902" TEXT="Limita el tama&#xf1;o de TABLA_A a un valor prefijado"/>
<node CREATED="1495316535849" ID="ID_499767738" MODIFIED="1495316631870" TEXT="Si hay que a&#xf1;adir un nodo a TABLA_A y no hay espacio, se elimina de ABIERTA y de TABLA_A el nodo con mayor f en ABIERTA"/>
<node CREATED="1495316632937" ID="ID_1894579516" MODIFIED="1495316669022" TEXT="Recuerda en cada nodo, el mejor f de los hijos olvidados de ese nodo"/>
<node CREATED="1495315344888" ID="ID_377312885" MODIFIED="1495315349718" TEXT="ABIERTA">
<node CREATED="1495315350649" ID="ID_1051862288" MODIFIED="1495315377870" TEXT="lista ordenada seg&#xfa;n f"/>
</node>
<node CREATED="1495316703169" ID="ID_1296995476" MODIFIED="1495316761331" TEXT="Completo (si la memoria disponible es suficiente para almacenar el camino a la soluci&#xf3;n menos profunda)">
<icon BUILTIN="info"/>
</node>
<node CREATED="1495316786681" ID="ID_1152539829" MODIFIED="1495316850571" TEXT="Admisible (si tiene suficiente memoria para almacenar el camino hasta la soluci&#xf3;n &#xf3;ptima menos profunda)">
<icon BUILTIN="info"/>
</node>
</node>
</node>
</node>
<node CREATED="1495296415507" ID="ID_1894128203" MODIFIED="1495362289343" TEXT="Voraces">
<icon BUILTIN="messagebox_warning"/>
<node CREATED="1495360859557" ID="ID_230572176" MODIFIED="1495360898428" TEXT="Toman decisiones de forma irrevocable en la exploraci&#xf3;n, sin considerar alternativas"/>
<node CREATED="1495360918901" ID="ID_1067387441" MODIFIED="1495360926565" TEXT="No completos">
<icon BUILTIN="button_cancel"/>
</node>
<node CREATED="1495360899534" ID="ID_343879403" MODIFIED="1495360908288" TEXT="No admisibles">
<icon BUILTIN="button_cancel"/>
</node>
<node CREATED="1495360940637" ID="ID_1432466261" MODIFIED="1495360961753" TEXT="Son muy eficientes por lo que se suelen usar en tiempo real"/>
</node>
<node CREATED="1495296420220" ID="ID_267083694" MODIFIED="1495362289343" TEXT="Ramificaci&#xf3;n y poda">
<node CREATED="1495311575615" ID="ID_1785334913" MODIFIED="1495311613372" TEXT="Cada estado es un subconjunto de soluciones del problema original"/>
<node CREATED="1495311613928" ID="ID_1205984257" MODIFIED="1495311666940" TEXT="El nodo ra&#xed;z representa todas las posibles soluciones al problema original"/>
<node CREATED="1495311675784" ID="ID_1219125635" MODIFIED="1495311683868" TEXT="Un nodo hoja contiene una soluci&#xf3;n"/>
<node CREATED="1495311718615" ID="ID_784593987" MODIFIED="1495311760724" TEXT="Cada nodo no terminal tendr&#xe1; asociado un heur&#xed;stico que es cota inferior del coste de la mejor soluci&#xf3;n"/>
<node CREATED="1495311780575" ID="ID_1042186172" MODIFIED="1495311832836" TEXT="Si un nodo rebasa el menor de los costes de los nodos hoja encontrados, el nodo se poda"/>
<node CREATED="1495311858407" ID="ID_1780815051" MODIFIED="1495311896068" TEXT="La estrategia de control acostumbra a ser en profundidad por ahorro de memoria, pero valen otras"/>
<node CREATED="1495311912767" ID="ID_907011306" MODIFIED="1495311988617" TEXT="Admisible (si recorre el espacio de b&#xfa;squeda (salvo lo podado) hasta vaciar ABIERTA)">
<icon BUILTIN="info"/>
</node>
</node>
<node CREATED="1495296425627" ID="ID_1633537293" MODIFIED="1495362289375" TEXT="B&#xfa;squeda local">
<node CREATED="1495314064224" ID="ID_292328400" MODIFIED="1495314103445" TEXT="Se usa si el nodo meta tiene toda la informaci&#xf3;n necesaria para la soluci&#xf3;n"/>
<node CREATED="1495314149728" ID="ID_1509266055" MODIFIED="1495314217740" TEXT="Realiza cambios del estado actual para ir a un estado vecino para acabar en un estado meta tras una serie de iteraciones"/>
<node CREATED="1495314423793" ID="ID_1228790395" MODIFIED="1495314438412" TEXT="A los estados se les asocia una funci&#xf3;n objetivo"/>
<node CREATED="1495314223976" ID="ID_1687477361" MODIFIED="1495314229004" TEXT="Regla de vecindad">
<node CREATED="1495314238241" ID="ID_921709647" MODIFIED="1495314277757" TEXT="Para calcular los estados vecinos y decidir a cual moverse"/>
<node CREATED="1495314292320" ID="ID_258901876" MODIFIED="1495314298020" TEXT="Criterio de aceptaci&#xf3;n">
<node CREATED="1495314330896" ID="ID_1032301194" MODIFIED="1495314346525" TEXT="Para decidir si hay que moverse"/>
</node>
<node CREATED="1495314347784" ID="ID_172878853" MODIFIED="1495314352420" TEXT="Criterio de finalizaci&#xf3;n">
<node CREATED="1495314360225" ID="ID_1473760865" MODIFIED="1495314375381" TEXT="Cuando se cumple, se da por finalizada la b&#xfa;squeda"/>
</node>
</node>
<node CREATED="1495312009847" ID="ID_231316806" MODIFIED="1495312014396" TEXT="Temple simulado">
<node CREATED="1495314509848" ID="ID_634232061" MODIFIED="1495314528212" TEXT="Selecci&#xf3;n aleatoria entre los vecinos del nodo actual"/>
<node CREATED="1495314549641" ID="ID_1049625559" MODIFIED="1495314675181" TEXT="El criterio de aceptaci&#xf3;n permite admitir con cierta probabilidad, transiciones a estados que empeoren el valor de la funci&#xf3;n objetivo. Esta probabilidad depende de la &quot;temperatura&quot; y el &quot;incremento de energ&#xed;a&quot;"/>
<node CREATED="1495314676264" ID="ID_248683023" MODIFIED="1495314720101" TEXT="Al principio la &quot;temperatura&quot; tiene un valor alto y va decreciendo a lo largo del proceso"/>
<node CREATED="1495314720720" ID="ID_196917232" MODIFIED="1495314773709" TEXT="La probabilidad de llegar a una buena soluci&#xf3;n es mayor si la temperatura inicial es alta y el enfriamiento es lento"/>
<node CREATED="1495314775120" ID="ID_1900694882" MODIFIED="1495314826413" TEXT="Requiere un ajuste apropiado de par&#xe1;metros (T y enfriamiento) para que resulte eficaz y obtenga una buena soluci&#xf3;n"/>
</node>
<node CREATED="1495312031608" ID="ID_863513518" MODIFIED="1495312035596" TEXT="M&#xe1;ximo gradiente">
<node CREATED="1495361067968" ID="ID_810129048" MODIFIED="1495361153068" TEXT="El criterio de aceptaci&#xf3;n es que la soluci&#xf3;n vecina sea mejor o igual que la soluci&#xf3;n actual"/>
<node CREATED="1495361159309" ID="ID_12397602" MODIFIED="1495361162283" TEXT="Problemas">
<node CREATED="1495361163270" ID="ID_1178985389" MODIFIED="1495361169500" TEXT="&#xd3;ptimos locales">
<node CREATED="1495361317421" ID="ID_1477279873" MODIFIED="1495361364050" TEXT="Si se alcanza uno, el algoritmo finaliza sin encontrar el &#xf3;ptimo global"/>
</node>
<node CREATED="1495361170509" ID="ID_1300964672" MODIFIED="1495361182108" TEXT="Regiones planas">
<node CREATED="1495361374950" ID="ID_1029102740" MODIFIED="1495361398167" TEXT="La b&#xfa;squeda es aleatoria porque ning&#xfa;n vecino mejora al actual"/>
</node>
<node CREATED="1495361183421" ID="ID_1849221923" MODIFIED="1495361189702" TEXT="Crestas"/>
</node>
</node>
<node CREATED="1495323273930" ID="ID_888438209" MODIFIED="1495323279551" TEXT="B&#xfa;squeda tab&#xfa;">
<node CREATED="1495323352403" ID="ID_1876335586" MODIFIED="1495323367543" TEXT="Lista tab&#xfa;">
<node CREATED="1495323368507" ID="ID_676756614" MODIFIED="1495323385983" TEXT="Mecanismo de memoria para evitar la generaci&#xf3;n de algunos vecinos"/>
<node CREATED="1495323402515" ID="ID_451783959" MODIFIED="1495323423391" TEXT="Criterio de aspiraci&#xf3;n">
<node CREATED="1495323424442" ID="ID_1477758921" MODIFIED="1495323493119" TEXT="Aquel por el que se aplican excepciones (p. ej. admitir nodos que mejoren al mejor nodo encontrado hasta el momento)"/>
</node>
<node CREATED="1495323500210" ID="ID_1473387232" MODIFIED="1495323561935" TEXT="Requiere un ajuste apropiado de par&#xe1;metros seg&#xfa;n el problema (tama&#xf1;o de lista tab&#xfa;, criterio de construcci&#xf3;n, criterio de aspiraci&#xf3;n, ...)"/>
</node>
</node>
</node>
</node>
</node>
</map>
