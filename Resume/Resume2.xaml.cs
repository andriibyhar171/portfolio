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
using System.Windows.Threading;

namespace Resume
{
    /// <summary>
    /// Interaction logic for Resume2.xaml
    /// </summary>
    public partial class Resume2 : Window
    {
        public Resume2()
        {
            InitializeComponent();
        }

        private void Makepdf2(object sender, RoutedEventArgs e)
        {
            PdfDocument pdf2 = new PdfDocument();
            pdf2.Info.Title = names2.Text;
            PdfPage pdfPage2 = pdf2.AddPage();
            XGraphics graph2 = XGraphics.FromPdfPage(pdfPage2);
            XFont fontx = new XFont(ed2.Text, slider2.Value + 30, XFontStyle.Bold); 
            XFont fonty = new XFont(ed2.Text, slider2.Value + 10, XFontStyle.Bold); 
            XFont fontz = new XFont(ed2.Text, slider2.Value + 20, XFontStyle.Bold); 
            XTextFormatter tf2 = new XTextFormatter(graph2);

            tf2.DrawString(name2.Text, fontx, XBrushes.Black, new XRect(230, 1, 575, 30));
            tf2.DrawString($"Address:{street2.Text} -- Phone:{phone2.Text}\n\t\t\t\t\t\t\t\t\tEmail: {email2.Text}", fonty, XBrushes.Black, new XRect(180, 40, 570, 60));

            graph2.DrawString("________________________________________________________________________________________________________________", fonty, XBrushes.Black, new XPoint(0, 80));

            tf2.DrawString($"{obj2.Text}\n", fonty, XBrushes.Black, new XRect(10, 100, 575, 75));

            tf2.DrawString("Experience:", fontz, XBrushes.Black, new XRect(10, 195, 575, 25));
            tf2.DrawString($"{date_from2.Text}\n{job_title2.Text}\n{respons2.Text}", fonty, XBrushes.Black, new XRect(30, 220, 575, 60));

            tf2.DrawString("Education:", fontz, XBrushes.Black, new XRect(10, 290, 575, 25));
            tf2.DrawString($"{schl_nam2.Text}\n{dat_of_gradu2.Text}\nGPA:{grade_point_average2.Text}", fonty, XBrushes.Black, new XRect(30, 310, 575, 75));

            tf2.DrawString("Skills:", fontz, XBrushes.Black, new XRect(10, 385, 575, 25));
            tf2.DrawString($"{skills.Text}\n", fonty, XBrushes.Black, new XRect(30, 410, 575, 50));

            tf2.DrawString("Hobbies:", fontz, XBrushes.Black, new XRect(10, 460, 575, 25));
            tf2.DrawString($"{hobbie2.Text}\n", fonty, XBrushes.Black, new XRect(30, 485, 575, 60));

            tf2.DrawString("Activities:", fontz, XBrushes.Black, new XRect(10, 545, 575, 25));
            tf2.DrawString($"{active.Text}\n", fonty, XBrushes.Black, new XRect(30, 570, 575, 60));

            pdf2.Save($"{path2.Text}{names2.Text + ".pdf"}");
            Process.Start($"{path2.Text}{names2.Text + ".pdf"}");
            //this.Close();
        }

        private void Ret2(object sender, RoutedEventArgs e)
        {
            MainWindow mainWindow = new MainWindow();
            mainWindow.Show();
            this.Close();
        }

        private void Close2(object sender, RoutedEventArgs e)
        {
            this.Close();
        }
        private void Zxc2(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            ((Slider)sender).SelectionEnd = e.NewValue;
        }
    }
}
