
<HTML>

<BODY LANG="ru-RU" LINK="#000080" VLINK="#800000" DIR="LTR">
<H2 CLASS="western" STYLE="font-style: normal; font-weight: normal"><FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=4><SPAN STYLE="background: transparent">Технологии</SPAN></FONT></FONT></FONT></H2>
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
<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=4><SPAN STYLE="background: transparent">Задание</SPAN></FONT></FONT></FONT></H2>
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
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">Программа
	парсит xls файл и выводит список всех не пустых колонок в одну
	колонку и дублированные названия полей в таблице во второй колонке </SPAN></FONT></FONT></FONT>
	</P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">Пользователь
	может отредактировать названия полей таблицы, но не колонок файла</SPAN></FONT></FONT></FONT></P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">При
	нажатии на кнопку сохранить программа создает таблицу - если ее нет
	и сохраняет все данные в базу, берет построчно значения полей и с
	помощью insert сохраняет их в БД</SPAN></FONT></FONT></FONT></P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">Данные
	о маппинге должны сохраниться в json файл</SPAN></FONT></FONT></FONT></P>
</OL>
<P STYLE="margin-bottom: 0cm"><BR>
</P>
<H2 CLASS="western" STYLE="font-style: normal; font-weight: normal; orphans: 1">
<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=4><SPAN STYLE="background: transparent">Варианты
решений:</SPAN></FONT></FONT></FONT></H2>
<UL>
	<LI><P STYLE="margin-bottom: 0cm"><SPAN LANG="en-US">branch</SPAN>
	<SPAN LANG="en-US">master</SPAN></P>
	<LI><P STYLE="margin-bottom: 0cm"><SPAN LANG="en-US">branch
	VARIANT_WITH_PREDEFINED_TABLES</SPAN> 
	</P>
	<LI><P STYLE="margin-bottom: 0cm"><SPAN LANG="en-US">branch
	VARIANT_WITH_PREDEFINED_ORM</SPAN> 
	</P>
</UL>
<H2 CLASS="western" STYLE="margin-left: 1.25cm; font-style: normal; font-weight: normal; orphans: 1">
<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=4><SPAN STYLE="background: transparent"><SPAN LANG="ru-RU">ВАРИАНТ
на </SPAN><SPAN LANG="en-US">branch</SPAN> <SPAN LANG="en-US">master</SPAN></SPAN></FONT></FONT></FONT></H2>
<OL START=6>
	<P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">Предполагает,
	что нет заранее предопределенных таблиц-сущностей. Т.е. Таблицы
	могут иметь любую структуру, которая полностью зависит от входного
	<SPAN LANG="en-US">xls </SPAN><SPAN LANG="ru-RU">файла. </SPAN></SPAN></FONT></FONT></FONT>
	</P>
	<P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent"><SPAN LANG="ru-RU">Об
	</SPAN><SPAN LANG="en-US">xls </SPAN><SPAN LANG="ru-RU">файле тоже
	ничего заранее не известно: ни на каком листе находятся данные, ни с
	какой строки начинаются, нет гарантий, что структура будет строго
	форматирована</SPAN></SPAN></FONT></FONT></FONT></P>
	<P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">Исходя
	из этого:</SPAN></FONT></FONT></FONT></P>
</OL>
<UL>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">имя
	таблицы вводится вручную</SPAN></FONT></FONT></FONT></P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent"><SPAN LANG="ru-RU">разбор
	</SPAN><SPAN LANG="en-US">xls </SPAN><SPAN LANG="ru-RU">файла по
	такой схеме: </SPAN></SPAN></FONT></FONT></FONT>
	</P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">1
	шаг ищем начало данных, предполагая, что они могут начинаться на
	любом листе и с любой строки. Первую строку данных считаем
	заголовком. Собираем имена заголовков столбцов. Они могут
	чередоваться с пустыми ячейками. </SPAN></FONT></FONT></FONT>
	</P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">2
	шаг выбираем данные. Данные, которые будут находится под пустым
	заголовком будут игнорироваться. В БД попадут только те данные, у
	которых есть заголовок, определенный на 1 шаге. Поэтому сразу
	собираем заголовки в виде мапы (номер_столбца &mdash; заголовок).</SPAN></FONT></FONT></FONT></P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">в
	качестве дублированных имен (имен полей таблицы БД) сразу выводятся
	имена столбцов из файла. </SPAN></FONT></FONT></FONT>
	</P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">Имена
	полей БД пользователь может изменить. Контроль ввода нового имени:
	латиница, не должно начинаться на цифру и длина не менее 2 символов,
	и не должно повторяться. </SPAN></FONT></FONT></FONT>
	</P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">При
	нажатии кнопки сохранения в БД проводится контроль введенного имени
	таблицы и контроль имен полей (не все могли меняться, поэтому не все
	могли проверить при вводе) . Критерию: латиница, не должно
	начинаться на цифру и длина не менее 2 символов, и не должно
	повторяться. </SPAN></FONT></FONT></FONT>
	</P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">Если
	таблица уже есть &mdash; предварительно удалится (возможны варианты,
	я выбрал такой). Данные помещаются в csv-файл (это учитывая фразу в
	описании задачи &laquo;настроить сохранение csv файла&raquo;). Затем
	из него &mdash; в БД.</SPAN></FONT></FONT></FONT></P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">После
	успешного сохранения, соответствие имен сохраняется в файле в виде
	json объекта. При этом, имя объекта = имя таблицы в БД, имя файла =
	имя xls файла + случайное число + &laquo;.json&raquo;</SPAN></FONT></FONT></FONT></P>
</UL>
<P STYLE="margin-bottom: 0cm"><BR>
</P>
<P ALIGN=CENTER STYLE="margin-bottom: 0cm"><B>файл, с которым
тестировал &mdash; <SPAN LANG="en-US">aaa.xls &ndash; </SPAN><SPAN LANG="ru-RU">прилагается</SPAN></B></P>
<P ALIGN=CENTER STYLE="margin-bottom: 0cm"><BR>
</P>
<H2 CLASS="western" STYLE="margin-left: 1.25cm; font-style: normal; font-weight: normal; orphans: 1">
<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=4><SPAN STYLE="background: transparent"><SPAN LANG="ru-RU">ВАРИАНТ
на </SPAN><SPAN LANG="en-US">VARIANT_WITH_PREDEFINED_TABLES</SPAN> </SPAN></FONT></FONT></FONT>
</H2>
<OL START=6>
	<P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">отличия
	от master</SPAN></FONT></FONT></FONT></P>
</OL>
<P ALIGN=CENTER STYLE="margin-bottom: 0cm"><BR>
</P>
<UL>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">все
	возможные таблицы БД заранее определены и являются сущностями модели</SPAN></FONT></FONT></FONT></P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">выбор
	имени таблицы, соответственно, производится из заранее определенного
	списка, основанного на&nbsp;<B>enum&nbsp;Tables</B></SPAN></FONT></FONT></FONT></P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">соответственно
	возникает ситуация возможного несовпадения множества столбцов xls и
	полей таблицы</SPAN></FONT></FONT></FONT></P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">после
	выбора таблицы БД, программа пытается автоматически по именам
	сопоставить поля сущности со столбцами из xls.</SPAN></FONT></FONT></FONT></P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">далее
	пользователь может менять привязку, но обязательное контролируемое
	требование &mdash; все поля таблицы должны быть сопоставлены
	столбцам файла. Также контролируется невозможность сопоставить поле
	таблицы более чем одному столбцу.</SPAN></FONT></FONT></FONT></P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">имена
	поле не вводятся, а выбираются из списка полей соответствующей
	таблицы-сущности</SPAN></FONT></FONT></FONT></P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent">сохранение
	в БД происходит также через csv (согласно условию)</SPAN></FONT></FONT></FONT></P>
	<LI><P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
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
<FONT COLOR="#000000"><FONT FACE="Courier New">}</FONT></FONT>
</PRE><H2 CLASS="western" STYLE="margin-left: 1.25cm; font-style: normal; font-weight: normal; orphans: 1">
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
	<FONT COLOR="#000000"><FONT FACE="Arial"><FONT SIZE=2 STYLE="font-size: 9pt"><SPAN STYLE="background: transparent"><SPAN LANG="ru-RU">Еще важное ограничение: </SPAN><SPAN LANG="en-US"> </SPAN><SPAN LANG="ru-RU">если в БД таблицы не существует, то она будет создана, но если она уже есть, то ее структура должна соответсвовать таблице-сущности</SPAN></SPAN></FONT></FONT></FONT></P>
	<P STYLE="margin-bottom: 0cm; background: transparent; font-style: normal; font-weight: normal; line-height: 138%; orphans: 1">
	</P>
</UL>
</BODY>
</HTML>
