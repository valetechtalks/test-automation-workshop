<?php

namespace App\Http\Controllers;

use App\Models\Attendee;

class DrawController extends Controller
{
    public function index() {
        $attendee = Attendee::where('awarded', '=', 0)
                      ->inRandomOrder()
                      ->first();

        $attendee->awarded = true;
        $attendee->save();

        return $attendee;
    }
}
