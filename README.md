<HTML>
<BODY LANG="ru-RU" LINK="#000080" VLINK="#800000" DIR="LTR">
<P ALIGN=CENTER STYLE="margin-bottom: 0cm"><B>Данный вариант, в
отличие от <SPAN LANG="en-US">master, </SPAN><SPAN LANG="ru-RU">отличается
следующим:</SPAN></B></P>
<P ALIGN=CENTER STYLE="margin-bottom: 0cm"><BR>
</P>
<UL>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; widows: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">все
	возможные таблицы БД заранее определены и являются сущностями модели</SPAN></FONT></FONT></FONT></P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; widows: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">выбор
	имени таблицы, соответственно, производится из заранее определенного
	списка, основанного на<B>&nbsp;enum&nbsp;Tables</B></SPAN></FONT></FONT></FONT></P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; widows: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">соответственно
	возникает ситуация возможного несовпадения множества столбцов xls и
	полей таблицы</SPAN></FONT></FONT></FONT></P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; widows: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">после
	выбора таблицы БД, программа пытается автоматически по именам
	сопоставить поля сущности со столбцами из xls.</SPAN></FONT></FONT></FONT></P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; widows: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">далее
	пользователь может менять привязку, но обязательное контролируемое
	требование &mdash; все поля таблицы должны быть сопоставлены
	столбцам файла. Также контролируется невозможность сопоставить поле
	таблицы более чем одному столбцу.</SPAN></FONT></FONT></FONT></P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; widows: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">имена
	поле не вводятся, а выбираются из списка полей соответствующей
	таблицы-сущности</SPAN></FONT></FONT></FONT></P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; widows: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">сохранение
	в БД происходит также через csv (согласно условию)</SPAN></FONT></FONT></FONT></P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; widows: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">Иначе
	формируется GSON объект для сохранения на диске. Теперь он имеет
	вид:</SPAN></FONT></FONT></FONT></P>
</UL>
<PRE STYLE="margin-left: 3.75cm; background: #ffffff"><FONT COLOR="#000000">{</FONT>
<FONT COLOR="#000000">  <FONT COLOR="#660e7a"><FONT FACE="Courier New"><B>&quot;XlsFileName&quot;</B></FONT></FONT><FONT FACE="Courier New">: </FONT><FONT COLOR="#008000"><FONT FACE="Courier New"><B>&quot;C:</B></FONT></FONT><FONT COLOR="#000080"><FONT FACE="Courier New"><B>\\</B></FONT></FONT><FONT COLOR="#008000"><FONT FACE="Courier New"><B>Users</B></FONT></FONT><FONT COLOR="#000080"><FONT FACE="Courier New"><B>\\</B></FONT></FONT><FONT COLOR="#008000"><FONT FACE="Courier New"><B>Valk</B></FONT></FONT><FONT COLOR="#000080"><FONT FACE="Courier New"><B>\\</B></FONT></FONT><FONT COLOR="#008000"><FONT FACE="Courier New"><B>Desktop</B></FONT></FONT><FONT COLOR="#000080"><FONT FACE="Courier New"><B>\\</B></FONT></FONT><FONT COLOR="#008000"><FONT FACE="Courier New"><B>bbb.xls&quot;</B></FONT></FONT><FONT FACE="Courier New">,</FONT></FONT>
<FONT COLOR="#000000">  <FONT COLOR="#660e7a"><FONT FACE="Courier New"><B>&quot;TableName&quot;</B></FONT></FONT><FONT FACE="Courier New">: </FONT><FONT COLOR="#008000"><FONT FACE="Courier New"><B>&quot;TABLE_2&quot;</B></FONT></FONT><FONT FACE="Courier New">,</FONT></FONT>
<FONT COLOR="#000000">  <FONT COLOR="#660e7a"><FONT FACE="Courier New"><B>&quot;Correspondences&quot;</B></FONT></FONT><FONT FACE="Courier New">: [</FONT></FONT>
<FONT COLOR="#000000">    <FONT FACE="Courier New">{</FONT></FONT>
<FONT COLOR="#000000">      <FONT COLOR="#660e7a"><FONT FACE="Courier New"><B>&quot;source&quot;</B></FONT></FONT><FONT FACE="Courier New">: </FONT><FONT COLOR="#008000"><FONT FACE="Courier New"><B>&quot;Field2_1&quot;</B></FONT></FONT><FONT FACE="Courier New">,</FONT></FONT>
<FONT COLOR="#000000">      <FONT COLOR="#660e7a"><FONT FACE="Courier New"><B>&quot;destination&quot;</B></FONT></FONT><FONT FACE="Courier New">: </FONT><FONT COLOR="#008000"><FONT FACE="Courier New"><B>&quot;field2_1&quot;</B></FONT></FONT></FONT>
<FONT COLOR="#000000"><FONT COLOR="#008000">    </FONT><FONT FACE="Courier New">},</FONT></FONT>
<FONT COLOR="#000000">    <FONT FACE="Courier New">{</FONT></FONT>
<FONT COLOR="#000000">      <FONT COLOR="#660e7a"><FONT FACE="Courier New"><B>&quot;source&quot;</B></FONT></FONT><FONT FACE="Courier New">: </FONT><FONT COLOR="#008000"><FONT FACE="Courier New"><B>&quot;ффф&quot;</B></FONT></FONT><FONT FACE="Courier New">,</FONT></FONT>
<FONT COLOR="#000000">      <FONT COLOR="#660e7a"><FONT FACE="Courier New"><B>&quot;destination&quot;</B></FONT></FONT><FONT FACE="Courier New">: </FONT><FONT COLOR="#008000"><FONT FACE="Courier New"><B>&quot;field2_2&quot;</B></FONT></FONT></FONT>
<FONT COLOR="#000000"><FONT COLOR="#008000">    </FONT><FONT FACE="Courier New">},</FONT></FONT>
<FONT COLOR="#000000">    <FONT FACE="Courier New">{</FONT></FONT>
<FONT COLOR="#000000">      <FONT COLOR="#660e7a"><FONT FACE="Courier New"><B>&quot;source&quot;</B></FONT></FONT><FONT FACE="Courier New">: </FONT><FONT COLOR="#008000"><FONT FACE="Courier New"><B>&quot;Field2_2&quot;</B></FONT></FONT><FONT FACE="Courier New">,</FONT></FONT>
<FONT COLOR="#000000">      <FONT COLOR="#660e7a"><FONT FACE="Courier New"><B>&quot;destination&quot;</B></FONT></FONT><FONT FACE="Courier New">: </FONT><FONT COLOR="#008000"><FONT FACE="Courier New"><B>&quot;field2_3&quot;</B></FONT></FONT></FONT>
<FONT COLOR="#000000"><FONT COLOR="#008000">    </FONT><FONT FACE="Courier New">}</FONT></FONT>
<FONT COLOR="#000000">  <FONT FACE="Courier New">]</FONT></FONT>
<FONT COLOR="#000000"><FONT FACE="Courier New"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN LANG="ru-RU"><SPAN STYLE="background: transparent"><FONT FACE="Courier New">}</FONT></SPAN></SPAN></FONT></FONT></FONT></PRE>
</BODY>
</HTML>
