using MigraDoc.DocumentObjectModel;
using MigraDoc.RtfRendering;
using PdfSharp.Drawing;
using PdfSharp.Drawing.Layout;
using PdfSharp.Pdf;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace Resume
{
    /// <summary>
    /// Interaction logic for Resume1.xaml
    /// </summary>
    public partial class Resume1 : Window
    {

        public Resume1()
        {
            InitializeComponent();
        }

        private void Makepdf(object sender, RoutedEventArgs e)
        {
            PdfDocument pdf = new PdfDocument();
            pdf.Info.Title = names.Text;
            PdfPage pdfPage = pdf.AddPage();
            XGraphics graph = XGraphics.FromPdfPage(pdfPage);
            XFont font2 = new XFont(ed.Text, slider.Value + 30, XFontStyle.Bold);
            XFont font3 = new XFont(ed.Text, slider.Value + 10, XFontStyle.Bold);
            XFont font4 = new XFont(ed.Text, slider.Value + 20, XFontStyle.Bold);
            XTextFormatter tf = new XTextFormatter(graph);

            tf.DrawString(name.Text, font2, XBrushes.DarkBlue,  new XRect(10, 1, 575, 30));
            tf.DrawString($"Street: {street.Text}\nCity: {city.Text}\nPhone: {phone.Text}\nEmail: {email.Text}", font3, XBrushes.Black, new XRect(10, 40, 570, 60));

            tf.DrawString("Objective:", font4, XBrushes.DarkBlue, new XRect(10, 110, 575, 25));
            tf.DrawString($"{obj.Text}\n", font3, XBrushes.Black, new XRect(10, 135, 575, 60));

            tf.DrawString("Education:", font4, XBrushes.DarkBlue, new XRect(10, 195, 575, 25));
            tf.DrawString($"{schl_nam.Text}\n{dat_of_gradu.Text}\nGPA:{grade_point_average.Text}", font3, XBrushes.Black, new XRect(10, 220, 575, 60));

            tf.DrawString("Experience:", font4, XBrushes.DarkBlue, new XRect(10, 285, 575, 25));
            tf.DrawString($"{date_from.Text}\n{job_title.Text}\n{respons.Text}", font3, XBrushes.Black, new XRect(10, 310, 575, 75));

            tf.DrawString("Awards & Acknowledgements:", font4, XBrushes.DarkBlue, new XRect(10, 385, 575, 25));
            tf.DrawString($"{awards.Text}\n", font3, XBrushes.Black, new XRect(10, 410, 575, 50));

            tf.DrawString("Hobbies:", font4, XBrushes.DarkBlue, new XRect(10, 460, 575, 25));
            tf.DrawString($"{hobbie.Text}\n", font3, XBrushes.Black, new XRect(10, 485, 575, 60));

            tf.DrawString("Highlights:", font4, XBrushes.DarkBlue, new XRect(10, 545, 575, 25));
            tf.DrawString($"{highlight.Text}\n", font3, XBrushes.Black, new XRect(10, 570, 575, 60));


            pdf.Save($"{path.Text}{names.Text + ".pdf"}");
            Process.Start($"{path.Text}{names.Text + ".pdf"}");
            //this.Close();
        }

        public void Ret(object sender, RoutedEventArgs e)
        {
            MainWindow mainWindow = new MainWindow();
            mainWindow.Show();
            this.Close();
        }

        private void Close(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void Zxc(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            ((Slider)sender).SelectionEnd = e.NewValue;
        }
    }
}
