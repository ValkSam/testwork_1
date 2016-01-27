<HTML>
<BODY LANG="ru-RU" LINK="#000080" VLINK="#800000" DIR="LTR">
<H2 CLASS="western" STYLE="font-style: normal; font-weight: normal"><FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=4 STYLE="font-size: 14pt"><SPAN STYLE="background: transparent">Технологии</SPAN></FONT></FONT></FONT></H2>
<OL>
	<LI><P STYLE="margin-bottom: 0cm; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#222222"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt">H2Database
	база данных (Удобна для тестирования) </FONT></FONT></FONT>
	</P>
	<LI><P STYLE="margin-bottom: 0cm; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#222222"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt">Hibernate
	как маппер обьектов в базу данных и работа с запросами к базе</FONT></FONT></FONT></P>
	<LI><P STYLE="margin-bottom: 0cm; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#222222"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt">Gson
	библиотека для работы с настройками</FONT></FONT></FONT></P>
	<LI><P STYLE="margin-bottom: 0cm; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#222222"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt">JavaFX
	для построения интерфейса приложения </FONT></FONT></FONT>
	</P>
</OL>
<H2 CLASS="western" STYLE="font-style: normal; font-weight: normal; orphans: 1">
<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=4 STYLE="font-size: 14pt"><SPAN STYLE="background: transparent">Задание</SPAN></FONT></FONT></FONT></H2>
<P STYLE="font-style: normal; font-weight: normal; orphans: 1"><FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">Нужно
написать простую программу в которой пользователь сможет <FONT COLOR="#ff00ff"><B>настроить
сохранение csv файла</B></FONT> в базу данных. </SPAN></FONT></FONT></FONT>
</P>
<P STYLE="font-style: normal; font-weight: normal; orphans: 1"><FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">Правила
сохранения следующие: </SPAN></FONT></FONT></FONT>
</P>
<OL>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">Пользователь
	выбирает файл</SPAN></FONT></FONT></FONT></P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">Пользователь
	выбирает название таблицы </SPAN></FONT></FONT></FONT>
	</P>
	<P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#ff0000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><B><SPAN STYLE="background: transparent">-
	в данном месте я не понял от куда выбирает, поэтому сделал простой
	ввод</SPAN></B></FONT></FONT></FONT></P>
	<P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; line-height: 138%; orphans: 1">
	</P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">Программа
	парсит xls файл и выводит список всех не пустых колонок в одну
	колонку и дублированные названия полей в таблице во второй колонке </SPAN></FONT></FONT></FONT>
	</P>
	<P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#ff0000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><B><SPAN STYLE="background: transparent">-
	разбор файла по такой схеме: сначала ищем начало данных,
	предполагая, что они могут начинаться на любом листе и с любой
	строки. Первую строку данных считаем заголовком.  Собираем имена
	заголовков столбцов. Они могут чередоваться с пустыми ячейками.
	Данные, которые потом могут находится под пустым заголовком будут
	игнорироваться. В БД попадут только те столбцы, у которых есть
	заголовок. Поэтому сразу собираем заголовки в виде мапы
	(номер_столбца &mdash; заголовок).</SPAN></B></FONT></FONT></FONT></P>
	<P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#ff0000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><B><SPAN STYLE="background: transparent">в
	качестве дублированных имен сразу выводятся поля из файла, которые
	затем можно изменить. </SPAN></B></FONT></FONT></FONT>
	</P>
	<P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	</P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">Пользователь
	может отредактировать названия полей таблицы, но не колонок файла</SPAN></FONT></FONT></FONT></P>
	<P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent"><FONT COLOR="#ff0000"><B>Контроль
	ввода нового имени по критерию: </B></FONT><FONT COLOR="#ff0000"><SPAN LANG="ru-RU"><B>латиница,
	</B></SPAN></FONT><FONT COLOR="#ff0000"><B>не должно начинаться на
	цифру и длина не менее 2 символов, и не должно повторяться</B></FONT>.
	</SPAN></FONT></FONT></FONT>
	</P>
</OL>
<P STYLE="margin-left: 0.36cm; margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
<BR>
</P>
<OL START=5>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">При
	нажатии на кнопку сохранить программа создает таблицу - если ее нет
	и сохраняет все данные в базу, берет построчно значения полей и с
	помощью insert сохраняет их в БД</SPAN></FONT></FONT></FONT></P>
	<P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent"><FONT COLOR="#ff0000"><B>Проводится
	контроль введенного имени таблицы и контроль имен столбцов (не все
	могли меняться, поэтому не все могли проверить при вводе) .
	Критерию: </B></FONT><FONT COLOR="#ff0000"><SPAN LANG="ru-RU"><B>латиница,
	</B></SPAN></FONT><FONT COLOR="#ff0000"><B>не должно начинаться на
	цифру и длина не менее 2 символов, и не должно повторяться</B></FONT>.
	</SPAN></FONT></FONT></FONT>
	</P>
	<P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; line-height: 138%; orphans: 1">
	</P>
	<P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#ff0000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><B><SPAN STYLE="background: transparent">Если
	таблица уже есть &mdash; предварительно удалится (возможны варианты,
	я выбрал такой). Данные помещаются в <SPAN LANG="en-US">csv-</SPAN><SPAN LANG="ru-RU">файл
	(это учитывая фразу в описании задачи &laquo;</SPAN><FONT COLOR="#ff00ff"><SPAN LANG="ru-RU">настроить
	сохранение csv файла</SPAN></FONT><SPAN LANG="ru-RU">&raquo;). Затем
	из него &mdash; в БД.</SPAN></SPAN></B></FONT></FONT></FONT></P>
	<P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; line-height: 138%; orphans: 1">
	</P>
</OL>
<P STYLE="margin-left: 0.36cm; margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
<BR>
</P>
<OL START=6>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">Данные
	о маппинге должны сохраниться в json файл</SPAN></FONT></FONT></FONT></P>
	<P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#ff0000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><B><SPAN STYLE="background: transparent">После
	успешного сохранения, соответствие имен сохраняется в файле в виде
	<SPAN LANG="en-US">json </SPAN>объекта. При этом, имя объекта = имя
	таблицы в БД, имя файла = имя <SPAN LANG="en-US">xls </SPAN>файла +
	случайное число + &laquo;.<SPAN LANG="en-US">json</SPAN>&raquo;</SPAN></B></FONT></FONT></FONT></P>
</OL>
<P STYLE="margin-bottom: 0cm"><BR>
</P>
<P ALIGN=CENTER STYLE="margin-bottom: 0cm"><B>файл, с которым
тестировал &mdash; <SPAN LANG="en-US">aaa.xls &ndash; </SPAN><SPAN LANG="ru-RU">прилагается (в main)</SPAN></B></P>
<P ALIGN=CENTER STYLE="margin-bottom: 0cm"><BR>
</P>
<P ALIGN=CENTER STYLE="margin-bottom: 0cm"><BR>
</P>
</BODY>
</HTML>
