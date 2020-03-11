<?php

namespace App\Http\Controllers;

use App\Models\Attendee;

class DrawController extends Controller
{
    public function index() {
        $attendee = Attendee::notAwarded()
                      ->inRandomOrder()
                      ->first();

        $attendee->awarded = true;
        $attendee->save();

        return $attendee;
    }
}
