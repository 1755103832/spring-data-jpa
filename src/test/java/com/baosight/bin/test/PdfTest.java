package com.baosight.bin.test;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @Author zyb
 * @Date Create in 2020/10/16 13:57
 * @Description
 **/
@SuppressWarnings("all")
public class PdfTest {
    public static void main(String[] args) {
        // 1.新建document对象
        Document document = new Document(PageSize.A4);
        //创建 PdfWriter 对象 第一个参数是对文档对象的引用，
        //第二个参数是文件的实际名称，在该名称中还会给出其输出路径
        String filePath = "E:\\BaiduNetdiskDownload\\PDFDemo.pdf";
        try {
            // 2.建立一个书写器(Writer)与document对象关联
            File file = new File(filePath);
            file.createNewFile();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
            //writer.setPageEvent(new Watermark("HELLO ITEXTPDF"));// 水印
            //writer.setPageEvent(new MyHeaderFooter());// 页眉/页脚

            // 3.打开文档
            document.open();
            document.addTitle("产品质量信息报告");// 标题
            document.addAuthor("Author@umiz");// 作者
            document.addSubject("Subject@iText pdf sample");// 主题
            document.addKeywords("Keywords@iTextpdf");// 关键字
            document.addCreator("Creator@");// 创建者
            document.add(new Paragraph("hello world"));
            // 4.向文档中添加内容
            //new PdfTest().generatePDF(document);
            // 5.关闭文档
            document.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 定义全局的字体静态变量
    private static Font titlefont;
    private static Font headfont;
    private static Font keyfont;
    private static Font textfont;
    private static Font redFont;
    // 最大宽度
    private static int maxWidth = 520;

    // 静态代码块
    static {
        try {
            // 不同字体（这里定义为同一种字体：包含不同字号、不同style）
            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            titlefont = new Font(bfChinese, 16, Font.BOLD);
            headfont = new Font(bfChinese, 14, Font.BOLD);
            keyfont = new Font(bfChinese, 10, Font.BOLD);
            textfont = new Font(bfChinese, 10, Font.NORMAL);
            //红色字体
            redFont = new Font(bfChinese, 10, Font.NORMAL);
            redFont.setColor(BaseColor.RED);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // 生成PDF文件
    public static void generatePDF(Document document, Image image, Image imageScott) throws Exception {

        // 段落1
        Paragraph paragraph = new Paragraph("带缺陷交付产品质量信息报告", titlefont);
        paragraph.setAlignment(1); //设置文字居中 0靠左   1，居中     2，靠右
        paragraph.setIndentationLeft(12); //设置左缩进
        paragraph.setIndentationRight(12); //设置右缩进
        paragraph.setFirstLineIndent(24); //设置首行缩进
        paragraph.setLeading(20f); //行间距
        paragraph.setSpacingBefore(5f); //设置段落上空白
        paragraph.setSpacingAfter(10f); //设置段落下空白

        Paragraph paragraph2 = new Paragraph("Quality Report of Product Delivered with Defects", titlefont);
        paragraph2.setAlignment(1); //设置文字居中 0靠左   1，居中     2，靠右
        paragraph2.setIndentationLeft(12); //设置左缩进
        paragraph2.setIndentationRight(12); //设置右缩进
        paragraph2.setFirstLineIndent(24); //设置首行缩进
        paragraph2.setLeading(20f); //行间距
        paragraph2.setSpacingBefore(5f); //设置段落上空白
        paragraph2.setSpacingAfter(10f); //设置段落下空白

        //文本信息1
//			Paragraph paragraph3 = new Paragraph("    铁损波动曲线 Iron Loss Deviation Curve："
//					+ "（无取向产品S合同不提供该曲线，铁损波动值dW=当前位置的铁损值-整卷平均铁损值）", textfont);
        Paragraph paragraph3 = new Paragraph();
        Chunk chunkNormal = new Chunk("    铁损波动曲线 Iron Loss Deviation Curve：", textfont);
        Chunk chunkRed = new Chunk("（无取向产品S合同不提供该曲线，铁损波动值dW=当前位置的铁损值-整卷平均铁损值）", redFont);

        paragraph3.add(chunkNormal);
        paragraph3.add(chunkRed);

        paragraph3.setAlignment(0); //设置文字居中 0靠左
        paragraph3.setLeading(20f); //行间距
        paragraph3.setIndentationLeft(12); //设置左缩进
        paragraph3.setSpacingBefore(5f); //设置段落上空白


        //文本信息2
        Paragraph paragraph4 = new Paragraph("注：长度方向的开始、结束位置为第一次分条使用该卷时的开始、结束位置。", textfont);
        paragraph4.setAlignment(0); //设置文字居中 0靠左
        paragraph4.setLeading(20f); //行间距
        paragraph4.setIndentationLeft(12); //设置左缩进
        paragraph4.setSpacingBefore(5f); //设置段落上空白

        //文本信息3
        Paragraph paragraph5 = new Paragraph("NOTE: The start & end of RD means the start & end of coil when first slitting this coil/pack.", textfont);
        paragraph5.setAlignment(0); //设置文字居中 0靠左
        paragraph5.setLeading(20f); //行间距
        paragraph5.setIndentationLeft(12); //设置左缩进
        paragraph5.setSpacingBefore(5f); //设置段落上空白

        //文本信息5
        Paragraph paragraph6 = new Paragraph("质量信息Surface Defect Information：", titlefont);
        paragraph6.setAlignment(0); //设置文字居中 0靠左
        paragraph6.setLeading(20f); //行间距
        paragraph6.setIndentationLeft(12); //设置左缩进
        paragraph6.setSpacingBefore(5f); //设置段落上空白

        //文本信息6
        Paragraph paragraph7 = new Paragraph("注：1、长度方向的开始、结束位置为第一次分条使用该卷时的开始、结束位置。", textfont);
        paragraph7.setAlignment(0); //设置文字居中 0靠左
        paragraph7.setLeading(20f); //行间距
        paragraph7.setIndentationLeft(12); //设置左缩进
        paragraph7.setSpacingBefore(5f); //设置段落上空白

        //文本信息7
        Paragraph paragraph8 = new Paragraph("2、宽度方向右手边侧指人面对开卷方向时的右手边；宽度方向左手边侧指人面对开卷方向时的左手边。", textfont);
        paragraph8.setAlignment(0); //设置文字居中 0靠左
        paragraph8.setLeading(20f); //行间距
        paragraph8.setIndentationLeft(12); //设置左缩进
        paragraph8.setSpacingBefore(5f); //设置段落上空白

        //文本信息8
        Paragraph paragraph9 = new Paragraph("NOTE:1. The start & end of RD means the start & end of coil when first slitting this coil/pack.", textfont);
        paragraph9.setAlignment(0); //设置文字居中 0靠左
        paragraph9.setLeading(20f); //行间距
        paragraph9.setIndentationLeft(12); //设置左缩进
        paragraph9.setSpacingBefore(5f); //设置段落上空白

        //文本信息9
        Paragraph paragraph10 = new Paragraph("2. Right side of TD means Right Hand Side when face to the opening position of Coil，while LS side means Left Hand Side when face to the opening position of Coil.", textfont);
        paragraph10.setAlignment(0); //设置文字居中 0靠左
        paragraph10.setLeading(20f); //行间距
        paragraph10.setIndentationLeft(12); //设置左缩进
        paragraph10.setSpacingBefore(5f); //设置段落上空白

        //文本信息9
        Paragraph paragraph11 = new Paragraph("示意图 Example：", titlefont);
        paragraph11.setAlignment(0); //设置文字居中 0靠左
        paragraph11.setLeading(20f); //行间距
        paragraph11.setIndentationLeft(12); //设置左缩进
        paragraph11.setSpacingBefore(5f); //设置段落上空白

        // 直线
        Paragraph p1 = new Paragraph();
        p1.add(new Chunk(new LineSeparator()));

        // 点线
        Paragraph p2 = new Paragraph();
        p2.add(new Chunk(new DottedLineSeparator()));

        // 超链接
        Anchor anchor = new Anchor("baidu");
        anchor.setReference("www.baidu.com");

        // 定位
        Anchor gotoP = new Anchor("goto");
        gotoP.setReference("#top");

        // 添加图片//铁损曲线
        Image image1 = image;//Image.getInstance("D:\\baoproject\\20200921智慧质检页面\\铁损曲线.jpg");
//			Image image1 = Image.getInstance("https://img-blog.csdn.net/20180801174617455?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNzg0ODcxMA==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70");
        image1.setAlignment(Image.ALIGN_CENTER);
        image1.scalePercent(40); //依照比例缩放

        // 添加图片//缺陷图
        Image image2 = imageScott;//Image.getInstance("D:\\baoproject\\20200921智慧质检页面\\缺陷位置示意图.jpg");
        image2.setAlignment(Image.ALIGN_CENTER);
        image2.scalePercent(40); //依照比例缩放

        // 添加图片
        Image image3 = Image.getInstance("D:\\BaiduNetdiskDownload\\images\\wallpaper.png");
        image3.setAlignment(Image.ALIGN_CENTER);
        image3.scalePercent(40); //依照比例缩放

        // 表格
        //PdfPTable table = createTable(new float[] { 40, 120, 120, 120, 80, 80 });
        //PdfPTable table = createTable(4,Element.ALIGN_CENTER);//指定列数和表格居中
        PdfPTable table = createTable(new float[]{120, 120, 120, 120});

        //table.addCell(createCell("美好的一天", headfont, Element.ALIGN_LEFT, 6, false));
        table.addCell(createCell("产品号 COIL/PACK", keyfont, Element.ALIGN_CENTER));
        table.addCell(createCell("19848888801", textfont, Element.ALIGN_CENTER));
        table.addCell(createCell("合同号 MILL'S NO.", keyfont, Element.ALIGN_CENTER));
        table.addCell(createCell("Q9E0000001", textfont, Element.ALIGN_CENTER));

        table.addCell(createCell("钢种牌号 Grade", keyfont, Element.ALIGN_CENTER));
        table.addCell(createCell("B23R085", textfont, Element.ALIGN_CENTER));
        table.addCell(createCell("最终用户名称 PURCHASER", keyfont, Element.ALIGN_CENTER));
        table.addCell(createCell("长鹰信质科技股份有限公司", textfont, Element.ALIGN_CENTER));

        table.addCell(createCell("炉次号 HEAT NO.", keyfont, Element.ALIGN_CENTER));
        table.addCell(createCell("19252458", textfont, Element.ALIGN_CENTER));
        table.addCell(createCell("技术标准 SPECIFICATION", keyfont, Element.ALIGN_CENTER));
        table.addCell(createCell("BXYS2018-001", textfont, Element.ALIGN_CENTER));

        table.addCell(createCell("厚度 THICK/mm", keyfont, Element.ALIGN_CENTER));
        table.addCell(createCell("0.23", textfont, Element.ALIGN_CENTER));
        table.addCell(createCell("宽度 WIDTH/mm", keyfont, Element.ALIGN_CENTER));
        table.addCell(createCell("1090", textfont, Element.ALIGN_CENTER));

        table.addCell(createCell("重量 MASS/kg", keyfont, Element.ALIGN_CENTER));
        table.addCell(createCell("18,000", textfont, Element.ALIGN_CENTER));
        table.addCell(createCell("理论长度 Length/m", keyfont, Element.ALIGN_CENTER));
        table.addCell(createCell("8500", textfont, Element.ALIGN_CENTER));

        // 表格2
        PdfPTable table2 = createTable(new float[]{120, 120, 120});
        table2.addCell(createCell("序号 NO.", keyfont, Element.ALIGN_CENTER));
        table2.addCell(createCell("缺陷名称 Defect Name", keyfont, Element.ALIGN_CENTER));
//			table2.addCell(createCell("长度方向位置 Position in RD", keyfont, Element.ALIGN_CENTER,3));
//			table2.addCell(createCell("宽度方向位置 Position in TD", keyfont, Element.ALIGN_CENTER,3));
        table2.addCell(createCell("缺陷程度 Defect Grade", keyfont, Element.ALIGN_CENTER));


        //createCell(String value, Font font, int align, int colspan)


        document.add(paragraph);
        document.add(paragraph2);
        //document.add(anchor);//超链接
        //document.add(p2);//点线
        //document.add(gotoP);//定位
        //document.add(p1);//直线
        document.add(table);
        document.add(paragraph3);
        document.add(image1);//铁损曲线
        document.add(paragraph4);
        document.add(paragraph5);
        document.add(paragraph6);
        document.add(image2);//缺陷位置示意图
        document.add(table2);
        document.add(paragraph7);
        document.add(paragraph8);
        document.add(paragraph9);
        document.add(paragraph10);
        document.add(paragraph11);
        document.add(image3);//示意图


    }


/**------------------------创建表格单元格的方法start----------------------------*/
    /**
     * 创建单元格(指定字体)
     *
     * @param value
     * @param font
     * @return
     */
    public static PdfPCell createCell(String value, Font font) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPhrase(new Phrase(value, font));
        return cell;
    }

    /**
     * 创建单元格（指定字体、水平..）
     *
     * @param value
     * @param font
     * @param align
     * @return
     */
    public static PdfPCell createCell(String value, Font font, int align) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(align);
        cell.setMinimumHeight(25F);//设置表格的高度
        cell.setPhrase(new Phrase(value, font));
        return cell;
    }

    /**
     * 创建单元格（指定字体、水平居..、单元格跨x列合并）
     *
     * @param value
     * @param font
     * @param align
     * @param colspan
     * @return
     */
    public static PdfPCell createCell(String value, Font font, int align, int colspan) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(align);
        cell.setColspan(colspan);
        cell.setPhrase(new Phrase(value, font));
        return cell;
    }

    /**
     * 创建单元格（指定字体、水平居..、单元格跨x列合并、设置单元格内边距）
     *
     * @param value
     * @param font
     * @param align
     * @param colspan
     * @param boderFlag
     * @return
     */
    public static PdfPCell createCell(String value, Font font, int align, int colspan, boolean boderFlag) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(align);
        cell.setColspan(colspan);
        cell.setPhrase(new Phrase(value, font));
        cell.setPadding(3.0f);
        if (!boderFlag) {
            cell.setBorder(0);
            cell.setPaddingTop(15.0f);
            cell.setPaddingBottom(8.0f);
        } else if (boderFlag) {
            cell.setBorder(0);
            cell.setPaddingTop(0.0f);
            cell.setPaddingBottom(15.0f);
        }
        return cell;
    }

    /**
     * 创建单元格（指定字体、水平..、边框宽度：0表示无边框、内边距）
     *
     * @param value
     * @param font
     * @param align
     * @param borderWidth
     * @param paddingSize
     * @param flag
     * @return
     */
    public static PdfPCell createCell(String value, Font font, int align, float[] borderWidth, float[] paddingSize, boolean flag) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(align);
        cell.setPhrase(new Phrase(value, font));
        cell.setBorderWidthLeft(borderWidth[0]);
        cell.setBorderWidthRight(borderWidth[1]);
        cell.setBorderWidthTop(borderWidth[2]);
        cell.setBorderWidthBottom(borderWidth[3]);
        cell.setPaddingTop(paddingSize[0]);
        cell.setPaddingBottom(paddingSize[1]);
        if (flag) {
            cell.setColspan(2);
        }
        return cell;
    }

    /**------------------------创建表格单元格的方法end----------------------------*/

    /**--------------------------创建表格的方法start------------------- ---------*/
    /**
     * 创建默认列宽，指定列数、水平(居中、右、左)的表格
     *
     * @param colNumber
     * @param align
     * @return
     */
    public static PdfPTable createTable(int colNumber, int align) {
        PdfPTable table = new PdfPTable(colNumber);
        try {
            table.setTotalWidth(maxWidth);
            table.setLockedWidth(true);
            table.setHorizontalAlignment(align);
            table.getDefaultCell().setBorder(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return table;
    }

    /**
     * 创建指定列宽、列数的表格
     *
     * @param widths
     * @return
     */
    public static PdfPTable createTable(float[] widths) {
        PdfPTable table = new PdfPTable(widths);
        try {
            table.setTotalWidth(maxWidth);// 设置表格的总宽度
            table.setLockedWidth(true);// 锁定宽度
            table.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.getDefaultCell().setBorder(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return table;
    }

    /**
     * 创建空白的表格
     *
     * @return
     */
    public static PdfPTable createBlankTable() {
        PdfPTable table = new PdfPTable(1);
        table.getDefaultCell().setBorder(0);
        table.addCell(createCell("", keyfont));
        table.setSpacingAfter(20.0f);
        table.setSpacingBefore(20.0f);
        return table;
    }
/**--------------------------创建表格的方法end------------------- ---------*/

}
