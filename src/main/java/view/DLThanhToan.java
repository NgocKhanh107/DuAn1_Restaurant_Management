/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import custom.DHCTBanHangCustom;
import custom.HDCTBanHangCustom;
import entity.Ban;
import entity.DonHang;
import entity.DonHangChiTiet;
import entity.HoaDon;
import entity.HoaDonChiTiet;
import entity.KhuVuc;
import entity.KhuyenMai;
import entity.MonAn;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.math.BigDecimal;
import java.text.AttributedCharacterIterator;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import service.impl.BanServiceImpl;
import service.impl.DonHangChiTietServiceImpl;
import service.impl.DonHangServiceImpl;
import service.impl.HoaDonChiTietServiceImpl;
import service.impl.HoaDonServiceImpl;
import service.impl.MonAnServiceImpl;




public class DLThanhToan extends javax.swing.JDialog {
    NumberFormat chuyentien = new DecimalFormat("#,###,###");
    BanServiceImpl bandao = new BanServiceImpl();
    DonHangServiceImpl dhdao = new DonHangServiceImpl();
    HoaDonServiceImpl hdao = new HoaDonServiceImpl();
    MonAnServiceImpl tddao = new MonAnServiceImpl();
    DonHangChiTietServiceImpl dhctdao = new DonHangChiTietServiceImpl();
    HoaDonChiTietServiceImpl hdctdao = new HoaDonChiTietServiceImpl();
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm a");
   DLThanhToan dlthanhtoan;
    /**
     * Creates new form DLThanhToan
     * @param parent
     * @param ngayTao;
     */
    int  idDH,phantram;
    String MaBan,MaGiamGia,MaNV;
    String tenBan;
    Date date;
    String MaHD;
    String MaDH;
    String TenMon;
    BigDecimal tong;
    BigDecimal tienthaydoi;
    DonHang arrhd;  
    HoaDon hoadon;
    List<DHCTBanHangCustom> order;
    List<HDCTBanHangCustom> dsmon;
    Double btHeight = 0.0;
    Double bbHeight = 0.0;
    public DLThanhToan(java.awt.Frame parent, boolean modal,BigDecimal  tienmon, String tenban, String maban, int iddh,String mahd,Date ngayTao,String tenMon,String maDH,BigDecimal tienThayDoi,String maNV) {
        super(parent, modal);
        initComponents();
        dlthanhtoan = this;
        tong = tienmon;
        idDH = iddh;
        date = ngayTao;
        MaHD = mahd;
        MaDH = maDH;
        MaBan = maban;
        MaNV = maNV;
        TenMon = tenMon;
        tenBan = tenban;
        tienthaydoi = tienThayDoi;
        jLabel1.setText(maban + " - Thanh toán");
        lblTongTien.setText(String.valueOf(tienmon.doubleValue()));
        lblMaHD.setText(mahd);     
        lblNgayTao.setText(df.format(ngayTao));
       
        arrhd = dhdao.getDHbyMa(maban);
        order = dhctdao.getDSOder(arrhd.getId());
        hoadon = hdao.getIDByMaHD(mahd);
        dsmon = hdctdao.getDSHDCT(hoadon.getId());
        
        DonHang dh = dhdao.findById(idDH);
        KhuyenMai km = dh.getIdKhuyenMai();
        MaGiamGia = km.getMaGiamGia();
        phantram = km.getPhanTram();
       // JOptionPane.showMessageDialog(this, order.size());
       // txtTong.setText();
       setFormHD();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTongTien = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTienDua = new javax.swing.JTextField();
        btnhuy = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbltienthoi = new javax.swing.JLabel();
        btnxacnhan = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblNgayTao = new javax.swing.JLabel();
        lblMaHD = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(500, 200));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(216, 226, 67));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 51)));

        lblTongTien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(220, 33, 33));
        lblTongTien.setText("....");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Tiền thừa");

        txtTienDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienDuaActionPerformed(evt);
            }
        });
        txtTienDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienDuaKeyReleased(evt);
            }
        });

        btnhuy.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnhuy.setForeground(new java.awt.Color(51, 51, 51));
        btnhuy.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\huymon.png")); // NOI18N
        btnhuy.setText("Hủy bỏ");
        btnhuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhuyActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 0));
        jLabel1.setText("Bàn 5 - Thanh toán");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Số tiền khách đưa:");

        lbltienthoi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltienthoi.setForeground(new java.awt.Color(209, 20, 20));
        lbltienthoi.setText("...");

        btnxacnhan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnxacnhan.setForeground(new java.awt.Color(51, 51, 51));
        btnxacnhan.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\check.png")); // NOI18N
        btnxacnhan.setText("Xác nhận");
        btnxacnhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxacnhanActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Số tiền cần trả:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Ngày Tạo");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Mã HĐ");

        lblNgayTao.setText("jLabel7");

        lblMaHD.setText("jLabel7");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(64, 64, 64))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(lblTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbltienthoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnxacnhan)
                                .addGap(28, 28, 28)
                                .addComponent(btnhuy))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMaHD)
                                    .addComponent(lblNgayTao)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTienDua, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblMaHD))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblNgayTao))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblTongTien))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lbltienthoi))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnxacnhan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnhuy, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtTienDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnhuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhuyActionPerformed
      //dlthanhtoan.setVisible(false);
      //HoaDonJDialog.hdjd.setVisible(true);
     dlthanhtoan.setVisible(false);
     
        // TODO add your handling code here:
    }//GEN-LAST:event_btnhuyActionPerformed

    private void txtTienDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienDuaKeyReleased
        try{
            //int tiendua =  Integer.parseInt(txtTienDua.getText());
           // BigDecimal tiendua = new BigDecimal(txtTienDua.getText());
           Double tiendua = Double.parseDouble(txtTienDua.getText());
            //BigDecimal tiendua = new BigDecimal(chuyentien.format(txtTienDua.getText()));
//            BigDecimal tienthua = tiendua.subtract(tong);
//            BigDecimal ss = new BigDecimal("0.0");
//            //if(tienthua >= 0)
//            if(tienthua.compareTo(ss) == 1){
//            lbltienthoi.setText(String.valueOf(chuyentien.format(tienthua))+ " VNĐ");
//            }
//            if(tiendua.compareTo(tong) == 0){
//                lbltienthoi.setText("0.0");
//            }
            Double tongtien = Double.parseDouble(lblTongTien.getText());
            double tiendu = 0;
            tiendu =  tiendua -tongtien ;
            if (tiendu < 0) {
                tiendu = tiendu * 1.0;
                this.lbltienthoi.setText("Còn thiếu:");
                this.lbltienthoi.setText(String.valueOf(tiendu)+"VNĐ");
            } else {
                this.lbltienthoi.setText(String.valueOf(tiendu)+"VNĐ");
                // this.txtTienThua.setText("Tiền dư:");
            }
        }catch(Exception e){
           // txtTienDua.setText("0.0");

        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienDuaKeyReleased

    private void btnxacnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxacnhanActionPerformed
        Ban b = new Ban();
        b.setTrangThai(0);
        b.setMaBan(MaBan);
        
        bandao.UpdateBan(b);
       
        DonHang dh = new DonHang();

        dh.setId(idDH);
        dh.setTrangThai(1);      
        dhdao.updatedonhang(dh);
        
        HoaDon hoadon = new HoaDon();
        hoadon.setMaHd(MaHD);
        hoadon.setTrangThai(1);
        hoadon.setNgayThanhToan(date);
        String update = hdao.UpdateTrangThaiban(hoadon);
        
//        DonHangCTViewModel dhctview = dhctdao.GetIDDHCT(TenMon, MaDH);
        HoaDon hd = hdao.getByMaDH(MaDH);        
        HoaDonChiTiet hdct = new HoaDonChiTiet();
        hdct.setIdHoaDon(hd);
      //  hdct.setIdDonHangChiTiet(dhct);
        String insert = hdctdao.addOrUpdate(hdct);
        String tien = lbltienthoi.getText();
//        double tienthoi = Double.parseDouble(tien);
//        if(tienthoi<0){
//            JOptionPane.showMessageDialog(this, "Tiền không đủ để thanh toán");
//        }
        try {
            double tienthoi = Double.parseDouble(tien);
        if(tienthoi<0){
            JOptionPane.showMessageDialog(this, "Tiền không đủ để thanh toán");
            return;
        }
        inHoaDon();
        } catch (Exception e) {
            
        }
        inHoaDon();
        Ban ban = bandao.getIDbyMa(MaBan);
        KhuVuc kv = ban.getIdKhuVuc();
        TestDonHang.dh.FillBan(bandao.getkhuvuc(kv.getId()));
        JpGoiMon1.gm.removeAll();
        TestDonHang.dh.fillLb();
        this.dispose();
    }//GEN-LAST:event_btnxacnhanActionPerformed

    private void txtTienDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienDuaActionPerformed
        // TODO add your handling code here:
        try{
            //int tiendua =  Integer.parseInt(txtTienDua.getText());
           // BigDecimal tiendua = new BigDecimal(txtTienDua.getText());
           Double tiendua = Double.parseDouble(txtTienDua.getText());
            //BigDecimal tiendua = new BigDecimal(chuyentien.format(txtTienDua.getText()));
//            BigDecimal tienthua = tiendua.subtract(tong);
//            BigDecimal ss = new BigDecimal("0.0");
//            //if(tienthua >= 0)
//            if(tienthua.compareTo(ss) == 1){
//            lbltienthoi.setText(String.valueOf(chuyentien.format(tienthua))+ " VNĐ");
//            }
//            if(tiendua.compareTo(tong) == 0){
//                lbltienthoi.setText("0.0");
//            }
            Double tongtien = Double.parseDouble(lblTongTien.getText());
            double tiendu = 0;
            tiendu =  tiendua -tongtien  ;
            if (tiendu < 0) {
                tiendu = tiendu * 1.0;
                this.lbltienthoi.setText("Còn thiếu:");
                this.lbltienthoi.setText(String.valueOf(tiendu)+"VNĐ");
            } else {
                this.lbltienthoi.setText(String.valueOf(tiendu)+"VNĐ");
                // this.txtTienThua.setText("Tiền dư:");
            }
        }catch(Exception e){
           // txtTienDua.setText("0.0");

        }        // TODO add your handling c
        
    }//GEN-LAST:event_txtTienDuaActionPerformed
   
    /**
     * @param args the command line arguments
     */
     private void inHoaDon() {
//        btHeight = Double.valueOf(loaiVe.size());
//        bbHeight = Double.valueOf(tenMon.size());

        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setPrintable(new BillPrintable(), getPageFormat(pj));
        try {
            //XDialog.alert(this, "Vui lòng tắt hoá đơn đang mở (nếu có) để in hoá đơn mới!");
            pj.print();
        } catch (PrinterException ex) {
            return;
        }
    }
     
    ArrayList<String> tenMon = new ArrayList<>();
    ArrayList<Integer> soLuongMon = new ArrayList<>();
    ArrayList<BigDecimal> donGiaMon = new ArrayList<>();
    ArrayList<BigDecimal> thanhTienMon = new ArrayList<>();
    
     private void setFormHD() {
//         arrhd = dhdao.getDHbyMa(MaBan);
        //order = dhctdao.getDSOder(arrhd.getId());
        dsmon = hdctdao.getDSHDCT(hoadon.getId());
        // JOptionPane.showMessageDialog(this, order.size());
        for (int i = 0; i < dsmon.size(); i++) {         
            int sl = dsmon.get(i).getSoLuong();
            String tenmon = dsmon.get(i).getTenMon();
            BigDecimal dongia  = new BigDecimal(dsmon.get(i).getDonGia()+""); 
            BigDecimal tien = new BigDecimal(sl).multiply(dongia);
            tenMon.add(tenmon);
            soLuongMon.add(sl);
            donGiaMon.add(dongia);
            thanhTienMon.add(tien);
        }
        }
    private PageFormat getPageFormat(PrinterJob pj) {

        PageFormat pf = pj.defaultPage();
        Paper paper = pf.getPaper();
        double bodyHeight = btHeight + bbHeight;
        double headerHeight = 5.0;
        double footerHeight = 8.0;
        double width = cm_to_pp(25);
        double height = cm_to_pp(headerHeight + bodyHeight + footerHeight);
        paper.setSize(width, height);
        paper.setImageableArea(0, 10, width, height - cm_to_pp(1));
        pf.setOrientation(PageFormat.PORTRAIT);
        pf.setPaper(paper);
        return pf;
    }

    protected static double cm_to_pp(double cm) {
        return toPPI(cm * 0.393600787);
    }

    protected static double toPPI(double inch) {
        return inch * 72d;
    }
    
     private class BillPrintable implements Printable {
      
        @Override
        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
          //  int r = tenMon.size();
            int result = NO_SUCH_PAGE;
            if (pageIndex == 0) {
                Graphics2D g2d = (Graphics2D) graphics;
                Graphics2D g2dtitle = (Graphics2D) graphics;
                Graphics2D g2dtt = (Graphics2D) graphics;
                g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());
                try {
                    int y = 20;
                    int yShift = 12;
                    int headerRectHeight = 15;
                 
                    ImageIcon logo = new ImageIcon("C:\\DuAn\\DuAn1\\src\\main\\java\\Images\\waiter.png");
                    g2d.drawImage(logo.getImage(), 162, 20, 100, 70, rootPane);
                    y += yShift + 90;
                    g2dtitle.setFont(new Font("Monospaced", Font.BOLD, 18));
                    g2dtitle.drawString(" PHIẾU THANH TOÁN ", 115, y);
                    y += yShift;
                    g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
                    g2d.drawString("    ----------------------------------------------------", 48, y);
                    y += headerRectHeight;
                    g2d.setFont(new Font("Monospaced", Font.BOLD, 9));
                    g2d.drawString("Bàn số:", 70, y);
                    g2d.drawString(MaBan, 155, y);
                    y += yShift;
                    g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
                    g2d.drawString("Giờ vào:", 70, y);
                    g2d.drawString(df.format(date), 155, y);
                   
                   
                 
                    y += yShift + 10;
                    g2d.drawString("Món", 70, y);
                    g2d.drawString("SL", 175, y);
                    g2d.drawString("Đ.Giá", 220, y);
                    g2d.drawString("T.Tiền", 290, y);
                    y += yShift - 2;
                    g2d.drawString("    ----------------------------------------------------", 48, y);
//                    arrhd = dhdao.getDHbyMa(MaBan);
//                    arrhd = dhdao.getDHbyMa(MaBan);
                    //order = dhctdao.getDSOder(arrhd.getId());
                     dsmon = hdctdao.getDSHDCT(hoadon.getId());
                    y += headerRectHeight;
                     for (int i = 0; i < dsmon.size(); i++) {
                        g2d.drawString(tenMon.get(i), 70, y);
                        g2d.drawString(String.valueOf(soLuongMon.get(i)), 175, y);
                        g2d.drawString((String.valueOf(donGiaMon.get(i))), 220, y);
                        g2d.drawString((String.valueOf(thanhTienMon.get(i))), 290, y);
                        y += yShift;
                    }
                   
                    g2d.drawString("    ----------------------------------------------------", 48, y);
                    y += yShift;
                    g2dtt.setFont(new Font("Monospaced", Font.BOLD, 9));
                     y += yShift + 2;
                    g2dtt.drawString("Mã NV:", 70, y);
                    g2dtt.drawString(MaNV , 290, y);
                    y += yShift + 2;
                     g2dtt.drawString("Tổng tiền:", 70, y);
                     g2dtt.drawString((String.valueOf(chuyentien.format(tienthaydoi)) +" VNĐ"), 290, y);
                    y += yShift + 2;
                    g2dtt.drawString("Giảm giá:", 70, y);
                    g2dtt.drawString(MaGiamGia +"-"+phantram+"%", 290, y);
                    g2dtt.setFont(new Font("Monospaced", Font.PLAIN, 9));
                
                    g2dtt.setFont(new Font("Monospaced", Font.BOLD, 9));
                    y += yShift + 2;
                    g2dtt.drawString("Thành tiền:", 70, y);
                     g2dtt.drawString(String.valueOf(lblTongTien.getText())+" VNĐ", 290, y);
                    y += yShift + 2;
                    g2dtt.drawString("Tiền khách đưa:", 70, y);
                    g2dtt.drawString(txtTienDua.getText()+" VNĐ", 290, y);
                    y += yShift + 2;
                    g2dtt.drawString("Tiền thừa:", 70, y);
                    g2dtt.drawString(lbltienthoi.getText()+" VNĐ", 290, y);
                    y += yShift;
                    g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
                    g2d.drawString("    ----------------------------------------------------", 48, y);
                    y += yShift;
                    g2d.drawString("   CHÚC QUÝ KHÁCH VUI VẺ, HẸN GẶP LẠI ", 95, y);
                    y += yShift;
                    g2d.drawString("   ********************************************", 50, y);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                result = PAGE_EXISTS;
            }
            return result;
        }
        
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnhuy;
    private javax.swing.JButton btnxacnhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblMaHD;
    private javax.swing.JLabel lblNgayTao;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lbltienthoi;
    private javax.swing.JTextField txtTienDua;
    // End of variables declaration//GEN-END:variables
}
