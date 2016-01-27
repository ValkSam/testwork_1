<HTML>

<BODY LANG="ru-RU" LINK="#000080" VLINK="#800000" DIR="LTR">
<P ALIGN=CENTER STYLE="margin-bottom: 0cm"><B>Данный вариант, в
отличие от <SPAN LANG="en-US">master, </SPAN><SPAN LANG="ru-RU">отличается
следующим:</SPAN></B></P>
<P ALIGN=CENTER STYLE="margin-bottom: 0cm"><BR>
</P>
<UL>
	<LI><P STYLE="margin-top: 0.1cm; margin-bottom: 0cm"><SPAN LANG="ru-RU">все
	возможные таблицы БД заранее определены и являются сущностями модели</SPAN></P>
	<LI><P STYLE="margin-top: 0.1cm; margin-bottom: 0cm"><SPAN LANG="ru-RU">указанные
	таблицы, соответсвенно, производится из заранее определенного
	списка, основанного на </SPAN><FONT COLOR="#000080"><FONT FACE="Courier New"><SPAN LANG="ru-RU"><B>enum
	</B></SPAN></FONT></FONT><FONT COLOR="#000000"><FONT FACE="Courier New"><SPAN LANG="ru-RU"><B>Tables</B></SPAN></FONT></FONT></P>
	<LI><P STYLE="margin-top: 0.1cm; margin-bottom: 0cm"><SPAN LANG="ru-RU">соответственно
	возникает ситуация возможного несовпадения множества полей </SPAN><SPAN LANG="en-US">xls
	</SPAN><SPAN LANG="ru-RU">и таблицы</SPAN></P>
	<LI><P STYLE="margin-top: 0.1cm; margin-bottom: 0cm"><SPAN LANG="ru-RU">когда
	</SPAN><SPAN LANG="en-US">xls </SPAN><SPAN LANG="ru-RU">файл
	загружен, мы видим все его столбцы-кандидаты. После выбора таблицы
	БД, программа пытается автоматически по именам сопоставить поля
	сущности со столбцами из </SPAN><SPAN LANG="en-US">xls.</SPAN></P>
	<LI><P STYLE="margin-top: 0.1cm; margin-bottom: 0cm">Далее
	пользователь может менять привязку, но обязательное контролируемое
	требование &mdash; все поля таблицы должны быть сопоставлены
	столбцам файла. При этом контролируется невозможность сопоставить
	поле таблицы более чем одному столбцу.</P>
	<LI><P STYLE="margin-top: 0.1cm; margin-bottom: 0cm">Имена поле не
	вводятся, а выбираются из списка полей соответсвующей
	таблицы-сущности</P>
	<LI><P STYLE="margin-top: 0.1cm; margin-bottom: 0cm">Сохранение в БД
	происходит также через <SPAN LANG="en-US">csv (</SPAN>согласно
	условию<SPAN LANG="en-US">)</SPAN></P>
	<LI><P STYLE="margin-top: 0.1cm; margin-bottom: 0cm">Иначе
	формируется <SPAN LANG="en-US">GSON </SPAN>объект для сохранения на
	диске. Теперь он имеет вид:</P>
	<P STYLE="margin-bottom: 0cm"></P>
</UL>
<PRE STYLE="margin-left: 2.44cm"><FONT COLOR="#000000"><FONT FACE="Courier New">{</FONT></FONT>
<FONT COLOR="#000000">  <FONT COLOR="#660e7a"><FONT FACE="Courier New"><B>&quot;XlsFileName&quot; </B></FONT></FONT><FONT FACE="Courier New">: </FONT><FONT COLOR="#008000"><FONT FACE="Courier New"><B>&quot;C:</B></FONT></FONT><FONT COLOR="#000080"><FONT FACE="Courier New"><B>\\</B></FONT></FONT><FONT COLOR="#008000"><FONT FACE="Courier New"><B>Users</B></FONT></FONT><FONT COLOR="#000080"><FONT FACE="Courier New"><B>\\</B></FONT></FONT><FONT COLOR="#008000"><FONT FACE="Courier New"><B>Valk</B></FONT></FONT><FONT COLOR="#000080"><FONT FACE="Courier New"><B>\\</B></FONT></FONT><FONT COLOR="#008000"><FONT FACE="Courier New"><B>Desktop</B></FONT></FONT><FONT COLOR="#000080"><FONT FACE="Courier New"><B>\\</B></FONT></FONT><FONT COLOR="#008000"><FONT FACE="Courier New"><B>bbb.xls&quot;</B></FONT></FONT><FONT FACE="Courier New">,</FONT></FONT>
<FONT COLOR="#000000">  <FONT COLOR="#660e7a"><FONT FACE="Courier New"><B>&quot;TableName&quot; </B></FONT></FONT><FONT FACE="Courier New">: </FONT><FONT COLOR="#008000"><FONT FACE="Courier New"><B>&quot;TABLE_2&quot;</B></FONT></FONT><FONT FACE="Courier New">,</FONT></FONT>
<FONT COLOR="#000000">  <FONT COLOR="#660e7a"><FONT FACE="Courier New"><B>&quot;Correspondences&quot; </B></FONT></FONT><FONT FACE="Courier New">: [ {</FONT></FONT>
<FONT COLOR="#000000">    <FONT COLOR="#660e7a"><FONT FACE="Courier New"><B>&quot;source&quot; </B></FONT></FONT><FONT FACE="Courier New">: </FONT><FONT COLOR="#008000"><FONT FACE="Courier New"><B>&quot;Field2_1&quot;</B></FONT></FONT><FONT FACE="Courier New">,</FONT></FONT>
<FONT COLOR="#000000">    <FONT COLOR="#660e7a"><FONT FACE="Courier New"><B>&quot;destination&quot; </B></FONT></FONT><FONT FACE="Courier New">: </FONT><FONT COLOR="#008000"><FONT FACE="Courier New"><B>&quot;field2_1&quot;</B></FONT></FONT></FONT>
<FONT COLOR="#000000"><FONT COLOR="#008000">  </FONT><FONT FACE="Courier New">}, {</FONT></FONT>
<FONT COLOR="#000000">    <FONT COLOR="#660e7a"><FONT FACE="Courier New"><B>&quot;source&quot; </B></FONT></FONT><FONT FACE="Courier New">: </FONT><FONT COLOR="#008000"><FONT FACE="Courier New"><B>&quot;ффф&quot;</B></FONT></FONT><FONT FACE="Courier New">,</FONT></FONT>
<FONT COLOR="#000000">    <FONT COLOR="#660e7a"><FONT FACE="Courier New"><B>&quot;destination&quot; </B></FONT></FONT><FONT FACE="Courier New">: </FONT><FONT COLOR="#008000"><FONT FACE="Courier New"><B>&quot;field2_2&quot;</B></FONT></FONT></FONT>
<FONT COLOR="#000000"><FONT COLOR="#008000">  </FONT><FONT FACE="Courier New">}, {</FONT></FONT>
<FONT COLOR="#000000">    <FONT COLOR="#660e7a"><FONT FACE="Courier New"><B>&quot;source&quot; </B></FONT></FONT><FONT FACE="Courier New">: </FONT><FONT COLOR="#008000"><FONT FACE="Courier New"><B>&quot;Field2_2&quot;</B></FONT></FONT><FONT FACE="Courier New">,</FONT></FONT>
<FONT COLOR="#000000">    <FONT COLOR="#660e7a"><FONT FACE="Courier New"><B>&quot;destination&quot; </B></FONT></FONT><FONT FACE="Courier New">: </FONT><FONT COLOR="#008000"><FONT FACE="Courier New"><B>&quot;field2_3&quot;</B></FONT></FONT></FONT>
<FONT COLOR="#000000"><FONT COLOR="#008000">  </FONT><FONT FACE="Courier New">} ]</FONT></FONT>
<FONT FACE="Courier New"><FONT COLOR="#000000">}</FONT></FONT></PRE>
<UL>
	<P STYLE="margin-bottom: 0cm"></P>
</UL>
</BODY>
</HTML>
