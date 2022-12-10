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
    /// Interaction logic for Resume3.xaml
    /// </summary>
    public partial class Resume3 : Window
    {
        public Resume3()
        {
            InitializeComponent();
        }

        private void Makepdf3(object sender, RoutedEventArgs e)
        {
            PdfDocument pdf3 = new PdfDocument();
            pdf3.Info.Title = names3.Text;
            PdfPage pdfPage3 = pdf3.AddPage();
            XGraphics graph3 = XGraphics.FromPdfPage(pdfPage3);
            XFont font_one = new XFont(ed3.Text, slider3.Value + 30, XFontStyle.Bold);
            XFont font_two = new XFont(ed3.Text, slider3.Value + 10, XFontStyle.Bold);
            XFont font_three = new XFont(ed3.Text, slider3.Value + 20, XFontStyle.Bold);
            XTextFormatter tf3 = new XTextFormatter(graph3);

            tf3.DrawString(name3.Text, font_one, XBrushes.DarkCyan, new XRect(10, 1, 575, 30));

            graph3.DrawString("________________________________________________________________________________________________________________", font_two, XBrushes.DarkCyan, new XPoint(0, 35));

            tf3.DrawString($"Address: {street3.Text} | City: {city3.Text} | Phone: {phone3.Text} | Email: {email3.Text}", font_two, XBrushes.Gray, new XRect(10, 40, 570, 20));

            tf3.DrawString("Objective", font_three, XBrushes.DarkCyan, new XRect(10, 65, 575, 25));
            tf3.DrawString($"{obj3.Text}\n", font_two, XBrushes.Gray, new XRect(10, 95, 575, 60));

            tf3.DrawString("Education", font_three, XBrushes.DarkCyan, new XRect(10, 160, 575, 25));
            tf3.DrawString($"{schl_nam3.Text}\n{dat_of_gradu3.Text}\nGPA:{grade_point_average3.Text}", font_two, XBrushes.Gray, new XRect(10, 190, 575, 60));

            tf3.DrawString("Skills & Abilities", font_three, XBrushes.DarkCyan, new XRect(10, 255, 575, 25));

            tf3.DrawString("Management", font_three, XBrushes.Black, new XRect(10, 285, 575, 25));
            tf3.DrawString($"{manage3.Text}\n", font_two, XBrushes.Gray, new XRect(10, 315, 575, 60));

            tf3.DrawString("Sales", font_three, XBrushes.Black, new XRect(10, 380, 575, 25));
            tf3.DrawString($"{sale3.Text}\n", font_two, XBrushes.Gray, new XRect(10, 410, 575, 60));

            tf3.DrawString("Communication", font_three, XBrushes.Black, new XRect(10, 475, 575, 25));
            tf3.DrawString($"{commun3.Text}\n", font_two, XBrushes.Gray, new XRect(10, 505, 575, 60));

            tf3.DrawString("Leadership", font_three, XBrushes.Black, new XRect(10, 570, 575, 25));
            tf3.DrawString($"{leader3.Text}\n", font_two, XBrushes.Gray, new XRect(10, 600, 575, 60));

            tf3.DrawString("Experience", font_three, XBrushes.DarkCyan, new XRect(10, 675, 575, 25));
            tf3.DrawString($"{date_from3.Text}\n{job_title3.Text}\n{respons3.Text}", font_two, XBrushes.Gray, new XRect(10, 705, 575, 50));

            pdf3.Save($"{path3.Text}{names3.Text + ".pdf"}");
            Process.Start($"{path3.Text}{names3.Text + ".pdf"}");
            //this.Close();
        }

        private void Ret3(object sender, RoutedEventArgs e)
        {
            MainWindow mainWindow = new MainWindow();
            mainWindow.Show();
            this.Close();
        }

        private void Close3(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void Zxc3(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            ((Slider)sender).SelectionEnd = e.NewValue;
        }
    }
}
