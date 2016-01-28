
<HTML>

<BODY LANG="ru-RU" LINK="#000080" VLINK="#800000" DIR="LTR">
<H2 CLASS="western"><BR><BR>
</H2>
<H2 CLASS="western" STYLE="margin-left: 1.25cm; font-style: normal; font-weight: normal; orphans: 1">
<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=4><SPAN STYLE="background: transparent"><SPAN LANG="ru-RU">ВАРИАНТ
на </SPAN><SPAN LANG="en-US">VARIANT_WITH_PREDEFINED_ORM</SPAN> </SPAN></FONT></FONT></FONT>
</H2>
<OL START=6>
	<P STYLE="margin-bottom: 0cm; background: transparent; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN LANG="ru-RU"><SPAN STYLE="font-style: normal"><SPAN STYLE="font-weight: normal"><SPAN STYLE="background: transparent">Отличия
	</SPAN></SPAN></SPAN></SPAN></FONT></FONT></FONT><FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN LANG="en-US"><SPAN STYLE="font-style: normal"><SPAN STYLE="font-weight: normal"><SPAN STYLE="background: transparent">от
	 </SPAN></SPAN></SPAN></SPAN></FONT></FONT></FONT><FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN LANG="ru-RU"><SPAN STYLE="font-style: normal"><B><SPAN STYLE="background: transparent">VARIANT_WITH_PREDEFINED_TABLES</SPAN></B></SPAN></SPAN></FONT></FONT></FONT></P>
	<P STYLE="margin-bottom: 0cm; background: transparent; line-height: 138%; orphans: 1">
	</P>
</OL>
<UL>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">сохранение
	в БД производится не через <SPAN LANG="en-US">CSV, </SPAN><SPAN LANG="ru-RU">а
	с использованием маппинга (с </SPAN><SPAN LANG="en-US">HQL</SPAN><SPAN LANG="ru-RU">)</SPAN><SPAN LANG="en-US">
	</SPAN></SPAN></FONT></FONT></FONT>
	</P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">таблицы
	модели соответственно  аннотированы и внесены изменения в
	hibernate.cfg.xml</SPAN></FONT></FONT></FONT></P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">для
	создания объектов модели создан <B>class TableFactory</B>	</SPAN></FONT></FONT></FONT></P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">при
	создании и инициализации объектов используется <SPAN LANG="en-US">reflaction</SPAN></SPAN></FONT></FONT></FONT></P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">реализована
	поддержка следующих типов полей таблиц (перечень можно легко
	расширить см. метод <SPAN LANG="en-US">XlsService.saveXlsToDb()</SPAN>):
	java.lang.String, java.lang.Integer. </SPAN></FONT></FONT></FONT>
	</P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent"><SPAN LANG="ru-RU">Поддержка
	типов накладывает естественные требование к совпадению типов
	значений в столбцах </SPAN><SPAN LANG="en-US">xls </SPAN><SPAN LANG="ru-RU">файла
	с типов сопоставляемых полей таблицы</SPAN></SPAN></FONT></FONT></FONT></P>
	<P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	</P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent"><SPAN LANG="ru-RU">Еще важное ограничение: </SPAN><SPAN LANG="en-US"> </SPAN><SPAN LANG="ru-RU">если в БД таблицы не существует, то она будет создана, но если она уже есть, то ее структура должна соответствовать таблице-сущности</SPAN></SPAN></FONT></FONT></FONT></P>
	<P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	</P>
</UL>
</BODY>
</HTML>
