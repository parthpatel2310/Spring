<?php
include('config.php');
$database = new Database();
$result = $database->runQuery("SELECT u.USER_NAME, sum(o.TOTAL) as TOTAL from order_master o join users u where o.USER_ID = u.USER_ID GROUP BY u.USER_ID");

require('fpdf/fpdf.php');
$pdf = new FPDF();
$pdf->AddPage();
$pdf->SetFont('Arial','B',16);

// Set header
 $pdf->Image('add1.jpg',7,1,25);
    // Move to the right
    $pdf->Cell(80);
    // Title
    $pdf->Cell(80,10,'User Order List',1,0,'C');
    // Line break
    $pdf->Ln(20);

$pdf->Cell(70,12,'User_Name',1);
$pdf->Cell(70,12,'Orders',1);


foreach($result as $row) {
	$pdf->Ln();
	foreach($row as $column)
		$pdf->Cell(70,12,$column,1);
}
$pdf->Output();

// Set footer
   $pdf->SetY(-15);
    // Arial italic 8
    $pdf->SetFont('Arial','I',8);
    // Page number
    $pdf->Cell(0,10,'Page '.$this->PageNo().'/{nb}',0,0,'C');
?>